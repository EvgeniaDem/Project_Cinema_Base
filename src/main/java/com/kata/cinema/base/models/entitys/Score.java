package com.kata.cinema.base.models.entitys;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "score", uniqueConstraints = @UniqueConstraint(columnNames = {"movie_id", "user_id"}))
public class Score {
    @Id
    @SequenceGenerator(name = "gen_score")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_score")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "score")
    private Integer score;

    @Column(name = "date")
    private LocalDate date;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Score score = (Score) o;
        return id != null && Objects.equals(id, score.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
