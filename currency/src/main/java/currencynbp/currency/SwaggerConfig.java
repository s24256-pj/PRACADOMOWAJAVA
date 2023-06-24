package currencynbp.currency;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Currency rest api")
                        .description("API DOCUMENTATION")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Marta")
                                .email("s24256@pjwstk.edu.pl")));
    }

}
