package com.sidia.prova.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sidia.prova.backend.model.Ratings;

public interface RatingsRepository extends JpaRepository<Ratings, Integer> {

}