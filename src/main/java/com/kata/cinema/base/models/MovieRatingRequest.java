package com.kata.cinema.base.models;

import lombok.Data;

@Data
public class MovieRatingRequest {

    private Integer score;
    private Long movieId;
}
