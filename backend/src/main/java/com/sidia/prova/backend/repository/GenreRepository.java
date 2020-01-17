package com.sidia.prova.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sidia.prova.backend.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}