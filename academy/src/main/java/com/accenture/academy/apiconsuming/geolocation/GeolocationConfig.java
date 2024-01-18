package com.accenture.academy.apiconsuming.geolocation;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "accenture.academy")
@Data
@Component
public class GeolocationConfig {

    private String apikey;
}
