package org.example.storeapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Store API",
                version = "1.0",
                description = "API for managing store articles"
        )
)
@SpringBootApplication
public class SwagerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(SwagerApplication.class, args);
    }
}
