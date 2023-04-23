package org.data.linking;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "WebApp data linking API", version = "1.0", description = "API REST"))
public class DataLinkingApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataLinkingApplication.class, args);
    }

}