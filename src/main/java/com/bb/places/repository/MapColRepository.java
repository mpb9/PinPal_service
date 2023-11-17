package com.bb.places.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bb.places.model.MapCol;

@Repository
public interface MapColRepository extends JpaRepository<MapCol, String> {

}
