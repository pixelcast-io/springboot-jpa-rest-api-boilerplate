package com.example.api.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.Collections;

@Configuration
public class SwaggerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerConfig.class);

    private static final String HTTPS_PROTOCOL = "https";

    private static final String HTTP_PROTOCOL = "http";

    //the api specific properties
    @SuppressWarnings("squid:S1075")
    private static final String API_NAME = "example-api";

    @Value("${docket.host.url}")
    private String docketHost;

    @Value("${api.terms}")
    private String apiTerms;

    @Value("${api.title}")
    private String apiTitle;

    @Value("${api.version}")
    private String apiVersion;

    @Value("${api.https.enabled:true}")
    private boolean httpsEnabled;

    @Value("${swagger.enabled}")
    private boolean swaggerEnabled;

    @Value("classpath:swagger-api-description.md")
    private Resource apiDescriptionMarkDown;

    private static String readResourceAsString(Resource resource) {
        String resourceContent = "";
        try (Reader reader = new InputStreamReader(resource.getInputStream())) {
            resourceContent = FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            LOGGER.warn("Error occurred while reading resource file and hence returning empty", e);
        }
        return resourceContent;
    }

    @Bean
    public OpenAPI loyaltyOpenAPI() {
        String protocol = httpsEnabled ? HTTPS_PROTOCOL : HTTP_PROTOCOL;
        Server server = new Server();
        server.setUrl(MessageFormat.format("{0}://{1}/{2}", protocol, docketHost, API_NAME));
        return new OpenAPI()
              .info(new Info()
                    .title(apiTitle)
                    .description(readResourceAsString(apiDescriptionMarkDown))
                    .version(apiVersion)
                    .termsOfService(apiTerms))
              .servers(Collections.singletonList(server));
    }
}
