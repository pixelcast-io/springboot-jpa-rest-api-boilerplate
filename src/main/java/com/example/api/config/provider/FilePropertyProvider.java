package com.example.api.config.provider;

import com.example.api.constant.ErrorCode;
import com.example.api.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import java.io.InputStream;
import java.util.Properties;

/**
 * The file based property provider
 *
 */
public class FilePropertyProvider extends PropertyProvider
      implements BeanDefinitionRegistryPostProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilePropertyProvider.class);

    public FilePropertyProvider(String... propertyFiles) throws ApiException {
        LOGGER.info("Initiating property file reader for {}", propertyFiles);
        ClassLoader classLoader = getClass().getClassLoader();

        if (propertyFiles != null) {
            Properties finalProps = new Properties();
            for (String propertyFile : propertyFiles) {
                try (InputStream input = classLoader.getResourceAsStream(propertyFile)) {

                    if (input == null) {
                        LOGGER.error("Cannot read the property file {}. Ignoring the file.", propertyFile);
                    } else {
                        Properties prop = new Properties();
                        prop.load(input);
                        prop.forEach((key, value) -> {
                            LOGGER.debug("Property loaded from test file " +
                                  "- Key {} Value {}", key, value);
                            finalProps.put(key, value);
                        });
                    }
                } catch (Exception ex) {
                    String error = "Error in loading configs !!! Aborting boot!";
                    LOGGER.error(error, ex);
                    throw new ApiException(ErrorCode.INTERNAL_ERROR_FAILED_TO_READ_APPLICATION_CONFIGURATIONS,
                            error,
                            null);
                }
            }
            setProperties(finalProps);
        } else {
            throw new IllegalArgumentException("No files to load properties from");
        }
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry){
        LOGGER.debug("Gracefully log");
    }
}
