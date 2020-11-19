package com.liziczh.archetype.admin.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.liziczh";
	public static final String PRODUCT_ENV = "product";
	@Value("${spring.profiles.active}")
	private String env;

	@Bean
	public Docket docket() {
		Docket docket = null;
		if (!PRODUCT_ENV.equals(env)) {
			docket = new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(apiInfo())
					.select()
					.apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
					.paths(PathSelectors.any())
					.build();
		} else {
			docket = new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(apiInfo())
					.select()
					.apis(RequestHandlerSelectors.none())
					.build();
		}
		return docket;
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("REST API")
				.version("1.0")
				.description("Swagger API")
				.build();
	}
}
