package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @SequenceGenerator(name = "gen_movies")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_movies")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "countries")
    private String countries;

    @Column(name = "date_release")
    private LocalDate dateRelease;

    @Column(name = "rars")
    @Enumerated(EnumType.STRING)
    private RARS rars;

    @Column(name = "mpaa")
    @Enumerated(EnumType.STRING)
    private MPAA mpaa;

    @Column(name = "time")
    private int time;

    @Column(name = "description")
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    @Column(name = "original_name")
    private String originalName;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    @OneToMany
    private List<Score> score;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movie movie = (Movie) o;
        return id != null && Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
