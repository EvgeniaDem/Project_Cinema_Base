package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.request.CommentsRequestDto;
import com.kata.cinema.base.models.entitys.Comments;
import com.kata.cinema.base.service.abstracts.model.CommentsService;
import com.kata.cinema.base.service.abstracts.model.NewsService;
import com.kata.cinema.base.service.abstracts.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user/news")
public class UserNewsRestController {
    private final NewsService newsService;
    private final UserService userService;
    private final CommentsService commentsService;

    @Autowired
    public UserNewsRestController(NewsService newsService, UserService userService, CommentsService commentsService) {
        this.newsService = newsService;
        this.userService = userService;
        this.commentsService = commentsService;
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<CommentsRequestDto> addComments(
            @PathVariable Long id, @RequestParam Long userId,
            @RequestBody CommentsRequestDto commentsRequestDto) {
        Comments comments = new Comments();
        comments.setDate(LocalDateTime.now());
        if (newsService.isExistById(id) && userService.isExistById(userId)) {
            comments.setNews(newsService.getById(id).orElseThrow());
            comments.setUser(userService.getById(userId).orElseThrow());
            commentsService.create(comments);
            return new ResponseEntity<>(commentsRequestDto, HttpStatus.OK);
        }
        throw new NotFoundByIdException("You entered incorrect data, try again or contact support");
    }
}
