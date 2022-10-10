package com.kata.cinema.base.service;

import com.kata.cinema.base.service.entity.MovieTicketsService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private final MovieTicketsService movieTicketsService;

    public ScheduleService(MovieTicketsService movieTicketsService) {
        this.movieTicketsService = movieTicketsService;
    }

    @Scheduled(cron = "0 0 6 * * ?")
    public void deleteMovieTickets() {
        movieTicketsService.addMovieTickets();
    }

    @Scheduled(cron = "0 0 6 * * ?")
    public void addMovieTickets() {
        movieTicketsService.deleteMovieTickets();
    }
}
