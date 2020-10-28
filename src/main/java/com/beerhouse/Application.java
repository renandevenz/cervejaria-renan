package com.beerhouse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableSwagger2
public class Application {

	@Value("${customer.swagger.path}")
	private String swaggerPath;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

		@Bean
		public Docket allApi() {
			ParameterBuilder parameterBuilder = new ParameterBuilder();
			parameterBuilder.name("Authorization")
					.modelRef(new ModelRef("string"))
					.parameterType("header")
					.required(false)
					.build();
			List<Parameter> parameters = new ArrayList<>();
			parameters.add(parameterBuilder.build());

			Set<String> protocols = new HashSet<>();
			protocols.add("http");
			protocols.add("https");

			return new Docket(DocumentationType.SWAGGER_2).host(swaggerPath)
					.groupName("All")
					.apiInfo(apiInfo())
					.select()
					.paths(PathSelectors.any())
					.build()
					.protocols(protocols)
					.ignoredParameterTypes(ApiIgnore.class)
					.enableUrlTemplating(true)
					.globalOperationParameters(parameters);
		}

		private ApiInfo apiInfo() {
			return new ApiInfoBuilder()
					.title("API Rest de Cadastro de cervejas artesanais")
					.description("Cervejas artesanais")
					.termsOfServiceUrl("http://localhost:8080")
					.license("")
					.licenseUrl("http://localhost:8080")
					.version("2.0")
					.build();
		}
}