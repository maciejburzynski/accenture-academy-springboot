package com.accenture.academy.apiconsuming.joke;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static java.lang.String.valueOf;

@RestController
@RequestMapping("/api/api-consuming")
@Slf4j
@RequiredArgsConstructor
public class JokeRestController {

    private final JokeService jokeService;

    @GetMapping
    void consumeApi() throws IOException, InterruptedException {
        Joke joke = jokeService.getRandomJoke();
    }


}
