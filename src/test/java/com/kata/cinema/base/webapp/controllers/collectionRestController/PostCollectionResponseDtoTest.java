package com.kata.cinema.base.webapp.controllers.collectionRestController;

import com.kata.cinema.base.AbstractTest;
import com.kata.cinema.base.models.dto.request.CollectionRequestDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.models.enums.CollectionType.MOVIES;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Sql(value = "/data/sql/controller/collectionRestController/CollectionInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/collectionRestController/CollectionClean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class PostCollectionResponseDtoTest extends AbstractTest {

    @Test
    public void postCollectionResponseDto() throws Exception {
        CollectionRequestDto collectionRequestDto = new CollectionRequestDto("new collection", MOVIES);
        this.mockMvc.perform(post("/api/collections")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(collectionRequestDto)))
                .andDo(print())
                .andExpect(status().isOk());

        Assert.assertTrue(entityManager.createQuery("SELECT count(c) > 0 FROM Collection c where c.name = :name and c.collectionType = :type", Boolean.class)
                .setParameter("name", "new collection")
                .setParameter("type", MOVIES)
                .getSingleResult());
    }
}
