package com.example.api.config;

import com.example.api.config.provider.FilePropertyProvider;
import com.example.api.config.provider.PropertyProvider;
import com.example.api.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfig {

    private static final String[] DEFAULT_PROPERTY_FILES = {"application.properties", "swagger.properties"};

    @Bean
    public PropertyProvider propertyConfigurer() throws ApiException {
        //TODO: Implement property providers based on the requirements.
        PropertyProvider propertiesProvider = null;
        propertiesProvider = new FilePropertyProvider(DEFAULT_PROPERTY_FILES);
        return propertiesProvider;
    }
}
