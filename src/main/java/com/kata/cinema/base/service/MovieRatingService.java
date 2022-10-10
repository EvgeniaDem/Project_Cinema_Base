package com.kata.cinema.base.service;

import com.kata.cinema.base.models.MovieRatingRequest;
import com.kata.cinema.base.models.entitys.User;

public interface MovieRatingService {
    void addRating(MovieRatingRequest request, User user);
}
