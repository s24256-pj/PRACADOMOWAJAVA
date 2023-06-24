package currencynbp.currency;

import java.util.ArrayList;

public class NbpApiResponse{
    public String table;
    public String currency;
    public String code;
    public ArrayList<Rate> rates;

    public String getCurrency() {
        return currency;
    }

    public String getTable() {
        return table;
    }

    public String getCode() {
        return code;
    }

    public ArrayList<Rate> getRates() {
        return rates;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setRates(ArrayList<Rate> rates) {
        this.rates = rates;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
