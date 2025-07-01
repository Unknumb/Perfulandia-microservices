package com.perfulandia.carritoservice.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Perfulandia")
                        .version("1.0.0")
                            .description("Documentación de la API para la tienda de Perfulandia.")
                        .contact(new Contact()
                                .name("Alvaro Uribe")
                                .email("juani@gmail.com")
                                .url("https://www.duoc.cl")
                        )
                        .license(new License()
                                .name("Licencia MIT")
                                .url("https://opensource.org/lecences/MIT")
                        )
                );
    }
}
