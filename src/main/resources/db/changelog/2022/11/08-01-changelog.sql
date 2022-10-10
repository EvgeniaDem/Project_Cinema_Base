-- liquibase formatted sql

-- changeset Евгения:1665307008356-2
ALTER TABLE score
    ADD date date;

-- changeset Евгения:1665307008356-3
CREATE UNIQUE INDEX "IX_pk_movie_person" ON movie_person (person_id, movie_id, profession_id);

-- changeset Евгения:1665307008356-1
ALTER TABLE movies
    ALTER COLUMN time SET NOT NULL;

