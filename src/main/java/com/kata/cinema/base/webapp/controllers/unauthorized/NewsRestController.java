package com.kata.cinema.base.webapp.controllers.unauthorized;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.dto.response.NewsBodyResponseDto;
import com.kata.cinema.base.models.dto.response.NewsTitleResponseDto;
import com.kata.cinema.base.service.dto.CommentDtoService;
import com.kata.cinema.base.service.dto.NewsDtoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@Api(tags = "Новости")
public class NewsRestController {
    private final CommentDtoService commentDtoService;
    private final NewsDtoService newsDtoService;

    public NewsRestController(CommentDtoService commentDtoService, NewsDtoService newsDtoService) {
        this.commentDtoService = commentDtoService;
        this.newsDtoService = newsDtoService;
    }

    @GetMapping("/latest")
    @ApiOperation(value = "Получение списка последних новостей", response = NewsTitleResponseDto.class, responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка последних новостей"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<List<NewsTitleResponseDto>> getLatestNews() {
        return ResponseEntity.ok(newsDtoService.getLatestNews());
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentsResponseDto>> getListOfComments(@PathVariable Long id) {
        if (!newsDtoService.isExistById(id)) {
            throw new NotFoundByIdException("News with id: " + id + " does not exist, try looking for another");
        }
        return ResponseEntity.ok(commentDtoService.getComments(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsBodyResponseDto> getNewsBody(@PathVariable Long id) {
        if (!newsDtoService.isExistById(id)) {
            throw new NotFoundByIdException("News with id: " + id + " does not exist, try looking for another");
        }
        return new ResponseEntity<>(newsDtoService.getByIdNewsBodyPageInfo(id), HttpStatus.OK);
    }
}
