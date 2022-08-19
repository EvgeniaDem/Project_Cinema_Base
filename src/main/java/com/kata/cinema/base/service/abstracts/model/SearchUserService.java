package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.dto.SearchUserResponseDto;

import java.util.List;

public interface SearchUserService {

    List<SearchUserResponseDto> findSearchUserByEmail(String email);
}
