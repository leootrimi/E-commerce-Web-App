package com.eCommerce.eCommerceApp.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Grupi 10",
                        email = "leotirm.halimi@student.uni-pr.edu",
                        url = "localhost:8080"
                ),
                description = "OpenApi Documentation of FindALL Project",
                title = "OpenApi"
        ),
        servers = {
                @Server(
                        description = "Local Host",
                        url = "http://localhost:8080"

)
}, security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
}
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT Auth",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {

}
