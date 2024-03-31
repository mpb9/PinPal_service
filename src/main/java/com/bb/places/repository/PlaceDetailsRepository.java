package com.bb.places.repository;

import com.bb.places.model.PlaceDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceDetailsRepository extends CrudRepository<PlaceDetails, String> {

}