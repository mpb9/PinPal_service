package com.bb.places.repository;

import com.bb.places.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {


	List<User> findAllByOrderById();

	List<User> findByPblc(int pblc);

	User findByEmailAndPassword(String email, String password);

	List<User> findByName(String name);

}
