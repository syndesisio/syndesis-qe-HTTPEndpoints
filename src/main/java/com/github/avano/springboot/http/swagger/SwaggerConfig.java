package com.github.avano.springboot.http.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		Set<String> protocols = new HashSet<>();
		protocols.add("http");
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/api/.*"))
				.build()
				.protocols(protocols)
				.tags(new Tag("HTTP Endpoints", "Endpoints for custom connector tests"))
				.apiInfo(new ApiInfo(
						"HTTP Endpoints",
						"Endpoints for custom connector tests",
						"1.0",
						"https://www.google.com",
						new Contact("John Doe", "https://www.google.com", "johndoe@acme.com"),
						"Apache 2.0",
						"http://www.apache.org/licenses/LICENSE-2.0",
						new ArrayList<>()
				));
	}
}
