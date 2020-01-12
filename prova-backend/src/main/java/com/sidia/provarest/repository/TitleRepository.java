package com.sidia.provarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sidia.provarest.model.Title;

public interface TitleRepository extends JpaRepository<Title, String> {

}