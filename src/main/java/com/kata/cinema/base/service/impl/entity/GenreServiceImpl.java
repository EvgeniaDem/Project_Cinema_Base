package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.dto.GenresDao;
import com.kata.cinema.base.models.dto.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import com.kata.cinema.base.service.abstracts.model.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenresDao genresDao;

    public GenreServiceImpl(GenresDao genresDao) {
        this.genresDao = genresDao;
    }

    @Override
    public List<GenreResponseDto> findGenres(Long id, String name) {
        return genresDao.getListOfGenres(id, name);
    }

    @Transactional
    @Override
    public void save(Genres genres) {
        genresDao.create(genres);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        genresDao.deleteById(id);
    }

    @Transactional
    @Override
    public void update(Genres genres) {
        genresDao.update(genres);
    }

    @Override
    public Genres getGenreById(Long id) {
        return genresDao.getById(id).orElseThrow();
    }
}
