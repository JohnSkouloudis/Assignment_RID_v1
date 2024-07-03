package com.rid.v1;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Documentation {

    @Bean
    public OpenAPI openAPI() {
        OpenAPI info = new OpenAPI() .info(new Info().title("Software Development Assignment_RID_v1")
                .description("")
                .version("1.0").contact(new Contact().name("Ioannis Skouloudis")
                        .email("").url("https://github.com/JohnSkouloudis/Assignment_RID_v1"))
                .license(new License().name("License of API")
                        .url("https://swagger.io/license/")));;

        return info;
    }

}
