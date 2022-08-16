package com.kata.cinema.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("IT")
public abstract class AbstractIT {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;

    public static final String NEWS_REST_CONTROLLER_INIT_SQL = "classpath:data/sql/controller/publicist/publicistNewsRestControllerInit.sql";
    public static final String NEWS_REST_CONTROLLER_CLEAR_SQL = "classpath:data/sql/controller/publicist/publicistNewsRestControllerClear.sql";
    public static final String SEARCH_REST_CONTROLLER_MOVIE_INIT_SQL = "classpath:data/sql/controller/SearchRestControllerMovieInit.sql";
    public static final String SEARCH_REST_CONTROLLER_MOVIE_CLEAR_SQL = "classpath:data/sql/controller/SearchRestControllerMovieClear.sql";

    public static final String GENRES_REST_CONTROLLER_INIT_SQL = "classpath:data/controller.genres.sql/AdminGenreRestControllerInit.sql";
    public static final String GENRES_REST_CONTROLLER_CLEAR_SQL = "classpath:data/controller.genres.sql/AdminGenreRestControllerClear.sql";
}
