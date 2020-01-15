package com.sidia.provarest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sidia.provarest.model.Title;

public interface TitleRepository extends JpaRepository<Title, String> {

	@Query(value = "SELECT distinct genres FROM sidia.title_genres where genres not in ('\\N') order by genres; ", nativeQuery = true)
	List<String> listGenres();
	
	Page<Title> findByStartYear(String startYear, Pageable pages);

	@Query("SELECT t FROM Title t INNER JOIN t.ratings r ORDER BY r.averageRating DESC")
	Page<Title> findTitleRatings(Pageable pages);

	@Query("SELECT t FROM Title t INNER JOIN t.ratings r where t.startYear = :startYear ORDER BY r.averageRating DESC")
	Page<Title> findTitleRatingsForYear(@Param("startYear") String startYear, Pageable pages);

}