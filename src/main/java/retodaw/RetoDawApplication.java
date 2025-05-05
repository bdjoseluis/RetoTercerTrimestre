package retodaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class RetoDawApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetoDawApplication.class, args);
	}

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("API Reto Daw")
                        .description("Proyecto de API REST")
                        .contact(new Contact()
                                .name("Reto Daw")
                                .email("")
                                .url("http://localhost:5001/swagger-ui/index.html"))
                        .version("1.0"));
    }

}
