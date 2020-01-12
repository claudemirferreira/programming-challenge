package com.sidia.provarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sidia.provarest.model.Ratings;

public interface RatingsRepository extends JpaRepository<Ratings, String> {

}