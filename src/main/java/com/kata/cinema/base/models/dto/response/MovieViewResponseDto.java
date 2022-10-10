package com.kata.cinema.base.models.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kata.cinema.base.models.entitys.Score;
import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieViewResponseDto {
    private Long id;

    @NotBlank
    private String name;
    private String originalName;

    private String countries;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateRelease;

    private RARS rars;
    private MPAA mpaa;
    private String description;
    private String previewUrl;
    private String genres;

    private List<Score> scores;
    private Integer countScore;
    private Integer myScore; // если пользователь не авторизован, myScore null

    private List<CastResponseDto> casts; // type=NO_CHARACTER_MOVIE

    public MovieViewResponseDto(Long id, String name, String originalName, String countries,
                                LocalDate dateRelease, RARS rars, MPAA mpaa, String description,
                                String previewUrl, String genres, List<Score> scores, Integer countScore, Integer myScore) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.countries = countries;
        this.dateRelease = dateRelease;
        this.rars = rars;
        this.mpaa = mpaa;
        this.description = description;
        this.previewUrl = previewUrl;
        this.genres = genres;
        this.scores = scores;
        this.countScore = countScore;
        this.myScore = myScore;
    }
}
