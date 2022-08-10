package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class AwardsCeremony {

    @Id
    @SequenceGenerator(name = "gen_awards_ceremony")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_awards_ceremony")
    private Long id;

    private String dateEvent;

    private String placeEvent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "awards_id")
    private Awards awards;

}
