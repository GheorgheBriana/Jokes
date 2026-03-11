package com.example.jokes2.repository;

import com.example.jokes2.model.JokeCollection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JokeRepository {
    private JdbcTemplate jdbcTemplate;

    public JokeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addJoke(JokeCollection.Joke joke) {
        String sql = "INSERT INTO jokes (category, joke, type) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, joke.getCategory(), joke.getJoke(), joke.getType());
    }
}
