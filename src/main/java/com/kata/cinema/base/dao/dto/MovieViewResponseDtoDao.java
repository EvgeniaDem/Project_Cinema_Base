package com.kata.cinema.base.dao.dto;

import com.kata.cinema.base.models.dto.response.CastResponseDto;
import com.kata.cinema.base.models.dto.response.MoviePersonResponseDto;
import com.kata.cinema.base.models.dto.response.MovieViewResponseDto;
import com.kata.cinema.base.models.entitys.User;

import java.util.List;

public interface MovieViewResponseDtoDao {
    MovieViewResponseDto getMovieViewResponse(long id, User user);

    List<CastResponseDto> getCastResponse(long id);

    List<MoviePersonResponseDto> getMoviePerson(long id);
}
