package com.kata.cinema.base.service;

import com.kata.cinema.base.dao.dto.MovieViewResponseDtoDao;
import com.kata.cinema.base.models.MovieRatingRequest;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.dto.response.MovieViewResponseDto;
import com.kata.cinema.base.models.entitys.Score;
import com.kata.cinema.base.models.entitys.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieRatingServiceImpl implements MovieRatingService {

    private final MovieViewResponseDtoDao movieViewResponseDtoDao;

    @Override
    public void addRating(MovieRatingRequest request, User user) {
        //MovieViewResponseDto movie = movieViewResponseDtoService.getMovieViewResponseDtoById(request.getMovieId(), user);
       /* log.info("rating service");
        Optional<Movie> movie1 = movieDtoService.getById(request.getMovieId());
        System.out.println(movie1.get());
        if (!movieDtoService.isExistById(request.getMovieId()))
            throw new NotFoundByIdException("Не существует такое кино");
        else if (request.getScore() < 0 && request.getScore() > 10) {
            throw new ScoreOutOfBoundException("Оценка фильма за пределами допустимого диапазона");
            // не пойму как проверить, ставил ли оценку фильму данный юзер - может, через Map или Set?
        } else if () {
            throw new ScoreRestrictionsException("Вы можете поставить только одну оценку");
        }*/
    }

    @Override
    public void deleteRating(Long movieId, User user) {
        log.info("delete movie movieId: {}", movieId);
        MovieViewResponseDto movieViewResponseDto = movieViewResponseDtoDao.getMovieViewResponse(movieId, user);
        System.out.println();
    }
}
