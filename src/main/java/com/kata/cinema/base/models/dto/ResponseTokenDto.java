package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseTokenDto {

    private String token;
    private String username;

}
