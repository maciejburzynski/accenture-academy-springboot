package com.accenture.academy.apiconsuming.geolocation;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.URI.create;

@Service
@Slf4j
@RequiredArgsConstructor
public class GeolocationService {

    private final GeolocationConfig config;


    @Value("${accenture.academy.api-key-from-value}")
    private String apiKey;

    @PostConstruct
    void getGeolocation() throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(create("https://api.geoapify.com/v1/ipinfo?&apiKey=" + apiKey)) // albo config.getApiKey()
                .build();

        HttpResponse httpResponse = httpClient
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        log.info(httpResponse.body().toString());


    }


}
