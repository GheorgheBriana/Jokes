package com.example.jokes2.controller;

import com.example.jokes2.model.JokeCollection;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JokeController {

    private RestTemplate restTemplate;

    public JokeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/jokes/{amount}")
    @ResponseBody
    public List<JokeCollection.Joke> getJokes(@PathVariable int amount) {
        String uri = "https://v2.jokeapi.dev/joke/any?amount={amount}";
        ResponseEntity<JokeCollection> responseEntity = restTemplate.getForEntity(uri, JokeCollection.class, amount);
        JokeCollection jokeCollection = responseEntity.getBody();
        return jokeCollection.getJokes();
    }

}
