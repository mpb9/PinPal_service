package com.bb.places.repository;

import com.bb.places.model.PinColl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinCollRepository extends CrudRepository<PinColl, String> {

    List<PinColl> findByUserId(String userId);

    List<PinColl> findByGuideId(String guideId);
}