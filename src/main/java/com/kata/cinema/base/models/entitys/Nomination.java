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
public class Nomination {

    @Id
    @SequenceGenerator(name = "gen_nomination")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_nomination")
    private Long id;

    private String name;

}
