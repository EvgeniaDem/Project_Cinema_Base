package com.kata.cinema.base.dao.dto;

import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.enums.СollectionSortType;

import java.util.List;
import java.util.Map;

public interface MovieResponseDtoDao {
    Map<Long, List<MovieResponseDto>> getMapMovieResponseValueByCollectionMoviesDtoIds(Map<String, Object> parameters, Long id);

    String getOrder(СollectionSortType collectionSortType);
}
