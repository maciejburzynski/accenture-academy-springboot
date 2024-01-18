package com.accenture.academy.apiconsuming.joke;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.String.valueOf;
import static java.net.URI.create;

@Service
@Slf4j
public class JokeService {


    @EventListener(ApplicationReadyEvent.class)
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

    public Joke getRandomJoke() throws IOException, InterruptedException {

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
        log.info("Type");
        log.info(joke.getType());
        log.info("Setup");
        log.info(joke.getSetup());
        log.info("Punchline");
        log.info(joke.getPunchline());
        log.info("Id");
        log.info(valueOf(joke.getId()));

        return joke;
    }


}
