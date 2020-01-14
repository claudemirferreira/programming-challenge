package com.sidia.provarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sidia.provarest.model.Name;

public interface NameRepository extends JpaRepository<Name, Integer> {

}