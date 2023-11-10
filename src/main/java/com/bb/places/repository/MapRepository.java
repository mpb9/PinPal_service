package com.bb.places.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bb.places.model.Map;

@Repository
public interface MapRepository extends JpaRepository<Map, Integer> {

}
