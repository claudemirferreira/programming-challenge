package com.sidia.provarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sidia.provarest.model.Title;

public interface TitleRepository extends JpaRepository<Title, String> {

	// Page<Title> findBy( String title, String status, String priority, String
	// userId, Pageable pages);

	@Query(value = "SELECT distinct genres FROM sidia.title_genres where genres not in ('\\N') order by genres; ", nativeQuery = true)
	List<String> listGenres();

}