package com.bb.places.service;

import com.bb.places.model.User;
import com.bb.places.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		logger.info("Entering UserService.getAllUsers...");
		return userRepository.findAllByOrderById();
	}

	public List<User> getPublicUsers() {
		logger.info("Entering UserService.getPublicUsers...");
		return userRepository.findByPblc(1);
	}

	public User getUserById(@NotBlank String id) {
		logger.info("Entering UserService.getUserById...");
		return userRepository.findById(id).get();
	}

	public User getUserByEmailAndPassword(@NotBlank String email, @NotBlank String password) {
		logger.info("Entering UserService.getUserByEmailAndPassword...");
		return userRepository.findByEmailAndPassword(email, password);
	}

	public List<User> getUsersByName(@NotBlank String name) {
		logger.info("Entering UserService.getUsersByName...");
		return userRepository.findByName(name);
	}

	@Transactional
	public void updateUser(@NotBlank String id, @Valid @NotNull User user) {
		logger.info("Entering UserService.updateUser...");
		User rtndUser = getUserById(id);
		rtndUser.setName(user.getName());
		rtndUser.setEmail(user.getEmail());
		rtndUser.setPassword(user.getPassword());
		rtndUser.setAbout(user.getAbout());
		rtndUser.setPblc(user.getPblc());
		userRepository.save(rtndUser);
	}

	@Transactional
	public void createUser(@Valid @NotNull User user) {
		logger.info("Entering UserService.createUser...");
		if (userRepository.existsById(user.getId()))
			updateUser(user.getId(), user);
		else
			userRepository.save(user);
	}

	@Transactional
	public void deleteUser(@Valid @NotNull User user) {
		logger.info("Entering UserService.deleteUser...");
		if (userRepository.existsById(user.getId()))
			userRepository.delete(user);
	}

	public void validateUser(@Valid @NotNull User user) {
		logger.info("Entering UserService.validateUser...");
		User userEnt = this.getUserByEmailAndPassword(user.getEmail(), user.getPassword());

		logger.info("UserEnt: {}", userEnt);
		logger.info("User: {}", user);
		if (!userEnt.equals(user)) {
			throw new RuntimeException("Unauthorized");
		}
	}

}
