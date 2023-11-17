package com.bb.places.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bb.places.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	List<User> findAllByOrderById();

	List<User> findByPblc(int pblc);

	User findByEmailAndPassword(String email, String password);

	List<User> findByName(String name);

}
