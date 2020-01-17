package com.sidia.prova.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sidia.prova.backend.model.Title;

public interface TitleRepository extends JpaRepository<Title, String> {

	Page<Title> findByStartYear(String startYear, Pageable pages);

	@Query("SELECT t FROM Title t INNER JOIN t.ratings r ORDER BY r.averageRating DESC")
	Page<Title> findTitleRatings(Pageable pages);

	@Query("SELECT t FROM Title t INNER JOIN t.ratings r where t.startYear = :startYear ORDER BY r.averageRating DESC")
	Page<Title> findTitleRatingsForYear(@Param("startYear") String startYear, Pageable pages);

}