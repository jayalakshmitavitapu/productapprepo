package com.productapp.config;

import org.springframework.context.annotation.Bean;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

public class Swagger2Configuration {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/api/javainuse.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("JavaInUse API")
				.description("JavaInUse API reference for developers")
				.termsOfServiceUrl("http://javainuse.com")
				.contact("javainuse@gmail.com").license("JavaInUse License")
				.licenseUrl("javainuse@gmail.com").version("1.0").build();
	}
}
