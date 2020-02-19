package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean
    public TaskList getTasklList() {
        return new TaskList();
    }

    @Bean
    public Board board() {
        return new Board(getTasklList(), getTasklList(), getTasklList());
    }
}
