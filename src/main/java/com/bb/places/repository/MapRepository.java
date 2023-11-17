package com.bb.places.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bb.places.model.Map;

@Repository
public interface MapRepository extends CrudRepository<Map, Integer> {

	List<Map> findAllByOrderById();

	List<Map> findByPblc(int pblc);

	List<Map> findByUserId(String userId);

	List<Map> findByUserIdAndPblc(String userId, int pblc);

}
