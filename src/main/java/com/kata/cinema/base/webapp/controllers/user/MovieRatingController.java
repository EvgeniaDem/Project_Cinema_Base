package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.MovieRatingRequest;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.MovieRatingService;
import com.kata.cinema.base.service.MovieRatingServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/movies")
@Slf4j
@RequiredArgsConstructor
public class MovieRatingController {

    private final MovieRatingService movieRatingService;

    @PostMapping("/add-rating")
    public void addRating(@RequestBody MovieRatingRequest request, @AuthenticationPrincipal User user){
        log.info("Получен фильм: {}, user: {}", request, user);
        movieRatingService.addRating(request, user);
    }
}
