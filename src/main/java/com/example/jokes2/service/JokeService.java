package com.example.jokes2.service;

import com.example.jokes2.model.JokeCollection;
import com.example.jokes2.repository.JokeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JokeService {
    private JokeRepository jokeRepository;

    private RestTemplate restTemplate;

    public JokeService(JokeRepository jokeRepository, RestTemplate restTemplate) {
        this.jokeRepository = jokeRepository;
        this.restTemplate = restTemplate;
    }

    public List<JokeCollection.Joke> getJokes(int amount) {
        String uri = "https://v2.jokeapi.dev/joke/any?amount={amount}";
        ResponseEntity<JokeCollection> responseEntity = restTemplate.getForEntity(uri, JokeCollection.class, amount);
        JokeCollection jokeCollection = responseEntity.getBody();
        return jokeCollection.getJokes();
    }

    public void addJoke(int amount) {
        List<JokeCollection.Joke> jokes = getJokes(amount);
        for(JokeCollection.Joke x : jokes) {
            if(x.getCategory() != null && x.getJoke() != null && x.getType() != null) {
                jokeRepository.addJoke(x);
            }
        }
    }
}
