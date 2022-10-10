package com.kata.cinema.base.service;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.MovieRatingRequest;
import com.kata.cinema.base.models.dto.response.MovieViewResponseDto;
import com.kata.cinema.base.models.entitys.Movie;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.dto.MovieDtoService;
import com.kata.cinema.base.service.dto.MovieViewResponseDtoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieRatingServiceImpl implements MovieRatingService {

    private final MovieDtoService movieDtoService;
    private final MovieViewResponseDtoService movieViewResponseDtoService;

    @Override
    public void addRating(MovieRatingRequest request, User user) {
        //MovieViewResponseDto movie = movieViewResponseDtoService.getMovieViewResponseDtoById(request.getMovieId(), user);
        log.info("rating service");
        Optional<Movie> movie1 = movieDtoService.getById(request.getMovieId());
        System.out.println(movie1.get());
        /*if (!movieDtoService.isExistById(request.getMovieId()))
            throw new NotFoundByIdException("Не существует такое кино");*/

    }
}
