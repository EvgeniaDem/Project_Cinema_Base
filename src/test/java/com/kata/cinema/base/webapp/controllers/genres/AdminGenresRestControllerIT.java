package com.kata.cinema.base.webapp.controllers.genres;

import com.kata.cinema.base.AbstractIT;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.kata.cinema.base.AbstractIT.GENRES_REST_CONTROLLER_CLEAR_SQL;
import static com.kata.cinema.base.AbstractIT.GENRES_REST_CONTROLLER_INIT_SQL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
@Sql(value = GENRES_REST_CONTROLLER_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = GENRES_REST_CONTROLLER_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class AdminGenresRestControllerIT extends AbstractIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getGenres() throws Exception {
        this.mockMvc.perform(get("/api/moderator/genres/1/?name=TEST1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createGenres() throws Exception {
        this.mockMvc.perform(post("/api/moderator/genres?name=TEST4")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateGenres() throws Exception {
        this.mockMvc.perform(put("/api/moderator/genres/51?name=test"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void deleteGenres() throws Exception {
        mockMvc.perform(delete("/api/moderator/genres/51"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}