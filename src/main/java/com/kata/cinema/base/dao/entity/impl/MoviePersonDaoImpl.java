package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.MoviePersonDao;
import com.kata.cinema.base.models.entitys.MoviePerson;
import com.kata.cinema.base.models.enums.TypeCharacter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MoviePersonDaoImpl extends AbstractDaoImpl<Long, MoviePerson> implements MoviePersonDao {
    //TODO переписать на трансформер
    public Map<Long, List<String>> getTwoMoviePersonMap() {
        List<Object[]> rows = entityManager.createQuery("select m.id, mp.nameCharacter from MoviePerson mp left join mp.movie m" +
                " where mp.type = :type")
                .setParameter("type", TypeCharacter.MAIN_CHARACTER)
                .getResultList();
        Map<Long, List<String>> moviePersonMap = new HashMap<>();
        for (int i = 0; i < rows.size(); i++) {
            Long key = (Long) rows.get(i)[0];
            String value = (String) rows.get(i)[1];
            moviePersonMap.computeIfAbsent(key, k -> new ArrayList<>());
            if (moviePersonMap.get(key).size() < 2) {
                moviePersonMap.get(key).add(value);
            }
        }
        return moviePersonMap;
    }

    @Override
    public List<String> getAllMainCharacterOfMovie(Long movieId) {
        return entityManager.createQuery("select mp.nameCharacter from MoviePerson mp join mp.movie m" +
                        " where m.id =:id and mp.type =:type", String.class)
                .setParameter("id", movieId)
                .setParameter("type", TypeCharacter.MAIN_CHARACTER)
                .getResultList();
    }

    @Override
    public List<Object[]> getMovieDirector(Long movieId) {
        return entityManager.createQuery("select p.firstName, p.lastName from MoviePerson mp join mp.movie m join mp.professions pr join mp.person p where m.id =:id and pr.name = 'режиссер'")
                .setParameter("id", movieId)
                .getResultList();
    }
}
