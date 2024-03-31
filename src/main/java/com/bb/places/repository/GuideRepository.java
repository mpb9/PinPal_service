package com.bb.places.repository;

import java.util.List;

import com.bb.places.model.Guide;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends CrudRepository<Guide, String> {

	Guide findByIdAndPblc(String id, int pblc);

	List<Guide> findAllByOrderById();

	List<Guide> findByPblc(int pblc);

	List<Guide> findByUserId(String userId);

	List<Guide> findByUserIdAndPblc(String userId, int pblc);

	int countByUserId(String userId);

}
