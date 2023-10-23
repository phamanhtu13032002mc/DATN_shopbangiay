package com.example.spring_boot.swagger2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    @Autowired
    private Environment env;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo())
                .securitySchemes(securitySchemes());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot REST API")
                .description("MMS Backend REST API")
                .contact(new Contact("Info plus", "info.mms.com", "tienlm@infoplusvn.com"))
                .license("1.0")
                .licenseUrl("https://www.fu.vn")
                .version("1.0.0")
                .build();
    }

    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .clientId(env.getProperty("spring.security.oauth2.client.registration.client-id")) // Your OAuth2 client ID
                .clientSecret(env.getProperty("spring.security.oauth2.client.registration.client-secret")) // Your OAuth2 client secret
                .scopeSeparator("")
                .useBasicAuthenticationWithAccessCodeGrant(false)
                .build();
    }

    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> schemes = new ArrayList<>();
        schemes.add(new OAuthBuilder()
                .name("oauth2")
                .grantTypes(grantTypes())
                .scopes(scopes())
                .build());
        return schemes;
    }

    private List<AuthorizationScope> scopes() {
        List<AuthorizationScope> scopes = new ArrayList<>();
        scopes.add(new AuthorizationScope("read", "Read access"));
        scopes.add(new AuthorizationScope("write", "Write access"));
        return scopes;
    }

    private List<GrantType> grantTypes() {
        List<GrantType> grantTypes = new ArrayList<>();
        GrantType passwordCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant(env.getProperty("spring.security.oauth2.client.registration.token-url"));
        grantTypes.add(passwordCredentialsGrant);
//        grantTypes.add(new ClientCredentialsGrant("http://localhost:8593/oauth/token"));
        return grantTypes;
    }
}
