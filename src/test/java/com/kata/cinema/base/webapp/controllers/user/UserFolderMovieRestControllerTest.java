package com.kata.cinema.base.webapp.controllers.user;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Ignore
//TODO переделать, как остальные тесты
public class UserFolderMovieRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserFolderMovieRestController userFolderMovieRestController;

    @Test
    @Disabled
    public void getOneFolderMovies() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/user/foldermovies/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Disabled
    public void getByUserId() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/user/foldermovies/userId"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}