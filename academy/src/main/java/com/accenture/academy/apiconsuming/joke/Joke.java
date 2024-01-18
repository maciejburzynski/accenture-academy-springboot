package com.accenture.academy.apiconsuming.joke;


import lombok.Data;

@Data
public class Joke {

    private String type;
    private String setup;
    private String punchline;
    private Integer id;

}
