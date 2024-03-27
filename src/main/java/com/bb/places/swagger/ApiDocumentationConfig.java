package com.bb.places.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Places API",
                description = "Places API for managing app resources",
                version = "1.0",
                license = @License(name = "Apache 2.0", url = "http://springdoc.org"),
                contact = @Contact(name = "Michael Beebe", email = "michaelbeebe1031@gmail.com", url = "")
        )
)
public interface ApiDocumentationConfig {
}