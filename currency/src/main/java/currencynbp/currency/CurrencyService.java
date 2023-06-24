package currencynbp.currency;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyService {
    private final CurrencyRepository currencyRepository;
    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public Currency saveCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    public double getMidValue(int days,String name) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/"+name+"/last/" + days + "/?format=json";
        double midSum = 0.0;

        NbpApiResponse nbpAPi = restTemplate.getForObject(url,NbpApiResponse.class);

        int count = 0;
        assert nbpAPi != null;
        for (Rate rate : nbpAPi.getRates() ) {
            double mid = rate.getMid();
                midSum += mid;
                count++;
        }
        if (count > 0) {
            return midSum / count;
        }
        else {
            return 0.0;
        }
    }
}


