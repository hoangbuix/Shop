package com.hoangbui.shopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    private static final String AUTH_END_POINT = "/api/v1/admin/user/login";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hoangbui.shopping"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiEndPointsInfo())
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Arrays.asList(apiCookieKey()));
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder()
                .title(" website")
                .description("REST API")
                .contact(new Contact("Hoang Bui", "", "buihoang9b8@gmail.com"))
                .version("1.0.0")
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(
                        Arrays.asList(new SecurityReference("spring_oauth", scopes())))
                .forPaths(PathSelectors.regex("/api/v1/.*"))
                .build();
    }

    private SecurityScheme securityScheme() {
        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(AUTH_END_POINT);
        SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
                .grantTypes(Arrays.asList(grantType))
                .scopes(Arrays.asList(scopes()))
                .build();

        return oauth;
    }

    @Bean
    public SecurityScheme apiCookieKey() {
        return new ApiKey(HttpHeaders.COOKIE, "apiKey", "cookie");
    }

    private AuthorizationScope[] scopes() {
        AuthorizationScope[] scopes = {
                new AuthorizationScope("read", "for read operations")
        };
        return scopes;
    }
}