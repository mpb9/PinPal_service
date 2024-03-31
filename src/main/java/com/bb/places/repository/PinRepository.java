package com.bb.places.repository;

import com.bb.places.model.Pin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinRepository extends CrudRepository<Pin, String>{

        Pin findByPlaceIdAndPinCollId(String placeId, String pinCollId);

        List<Pin> findByPinCollId(String pinCollId);
}