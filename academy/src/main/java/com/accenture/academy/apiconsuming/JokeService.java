package com.accenture.academy.apiconsuming;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.String.valueOf;
import static java.net.URI.create;

@Service
@Slf4j
public class JokeService {


    @PostConstruct
    public void getJoke() throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(create("https://official-joke-api.appspot.com/random_joke"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String response = httpResponse.body().toString();

        ObjectMapper objectMapper = new ObjectMapper();
        Joke joke = objectMapper.readValue(response, Joke.class);

        System.out.println("Sout");
        System.out.println(response);

        log.info("Logging");
        log.info(response);

        log.info("Type");
        log.info(joke.getType());
        log.info("Setup");
        log.info(joke.getSetup());
        log.info("Punchline");
        log.info(joke.getPunchline());
        log.info("Id");
        log.info(valueOf(joke.getId()));



    }


}
