package com.example.jokes2.controller;

import com.example.jokes2.model.JokeCollection;
import com.example.jokes2.service.JokeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JokeController {

    private JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/jokes/{amount}")
    @ResponseBody
    public List<JokeCollection.Joke> getJokes(@PathVariable int amount) {
        return jokeService.getJokes(amount);
    }

    @GetMapping("/jokes/{amount}/add")
    @ResponseBody
    public String addJoke(@PathVariable int amount) {
        int addedJokes = jokeService.addJoke(amount);
        return addedJokes + " jokes added to database";
    }


}
