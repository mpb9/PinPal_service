package com.bb.places.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                description = "Places API for managing app resources",
                version = "1.0",
                title = "Places API",
                contact = @Contact(name = "Michael Beebe", email = "michaelbeebe1031@gmail.com"),
                license = @License(name = "Apache 2.0", url = "http://springdoc.org")
        )
)
public interface ApiDocumentationConfig {
}