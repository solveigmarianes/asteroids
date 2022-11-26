package com.plommesaft.asteroids.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration("asteroidClientProperties")
@ConfigurationProperties(prefix = "asteroids.client")
public class AsteroidClientProperties {

    @Value("${asteroids.client.base-path}")
    private String basePath;

    @Value("${asteroids.client.api-key}")
    private String apiKey;

    public String getBasePath() {
        return basePath;
    }

    public String getApiKey() {
        return apiKey;
    }
}
