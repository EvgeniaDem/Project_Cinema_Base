package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.Rubric;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class News {

    @Id
    @SequenceGenerator(name = "gen_news")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_news")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Rubric rubric;

    @NotNull
    private LocalDate date;

    @NotNull
    private String title;

    @NotNull
    private String htmlBody;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "news_movie",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movies> movies;

}
