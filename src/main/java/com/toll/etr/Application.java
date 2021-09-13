package com.toll.etr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

	@Bean
	public Docket swaggerConfig() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/tollCalculatorService/**"))
				.build()
				.apiInfo(apiDetail());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public ApiInfo apiDetail() {
		
		return new ApiInfo("ETR 407 Toll Service", "Service to calculate charge for ETR 407", "V 1.0", "Open", "Annamalai Thiagarajan", null, null);
	}
}
