package com.bb.places.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bb.places.model.PlaceCol;

@Repository
public interface PlaceColRepository extends JpaRepository<PlaceCol, String> {

}
