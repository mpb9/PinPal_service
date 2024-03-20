package com.bb.places.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.places.model.User;
import com.bb.places.service.UserService;
import com.bb.places.util.RegExConstants;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

// GET REQUESTS
	@GetMapping(name = "Get All Users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		logger.info("Entering UserController.getAllUsers...");

		List<User> userList = userService.getAllUsers();

		logger.info("\nUsers: {}", userList);

		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@GetMapping(name = "Get Public Users", value = "/pub", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getPublicUsers() {
		logger.info("Entering UserController.getPublicUsers...");

		List<User> userList = userService.getPublicUsers();

		logger.info("\nUsers: {}", userList);

		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

// PUT REQUESTS
	@PutMapping(name = "Update User By ID", value = "/{id}")
	public ResponseEntity<String> updateUserById(
			@PathVariable @Pattern(regexp = RegExConstants.VALID_USER_ID) String id,
			@Valid @NotNull @RequestBody User user) {
		logger.info("Entering UserController.updateUser...");

		userService.updateUser(id, user);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

// POST REQUESTS
	@PostMapping(name = "Create User")
	public ResponseEntity<String> createUser(@Valid @NotNull @RequestBody User user) {
		logger.info("Entering UserController.createUser...");

		userService.createUser(user);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

// DELETE REQUESTS
	@DeleteMapping(name = "Delete User")
	public ResponseEntity<String> deleteUser(@Valid @NotNull @RequestBody User user) {
		logger.info("Entering UserController.deleteUser...");

		userService.deleteUser(user);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
