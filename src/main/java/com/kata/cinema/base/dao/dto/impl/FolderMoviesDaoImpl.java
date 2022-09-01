package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.entity.FolderMoviesDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.entitys.FolderMovies;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class FolderMoviesDaoImpl extends AbstractDaoImpl<Long, FolderMovies> implements FolderMoviesDao {

    private EntityManager entityManager;

    public FolderMoviesDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public FolderMovies findByUserId(long id) {

        return entityManager.createQuery("SELECT f from FolderMovies f where f.user.id=:id", FolderMovies.class)
                .setParameter("id", id).getSingleResult();
    }
}
