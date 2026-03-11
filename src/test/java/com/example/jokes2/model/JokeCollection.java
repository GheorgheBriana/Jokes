package com.example.jokes2.model;

import java.util.List;

public class JokeCollection {
    private boolean error;
    private int amount;
    private List<Joke> jokes;

    public JokeCollection() {
    }

    public JokeCollection(boolean error, int amount, List<Joke> jokes) {
        this.error = error;
        this.amount = amount;
        this.jokes = jokes;
    }

    public static class Joke {
        private String category;
        private String type;
        private String joke;

        public Joke() {
        }

        public Joke(String category, String type, String joke) {
            this.category = category;
            this.type = type;
            this.joke = joke;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getJoke() {
            return joke;
        }

        public void setJoke(String joke) {
            this.joke = joke;
        }
    }

}
