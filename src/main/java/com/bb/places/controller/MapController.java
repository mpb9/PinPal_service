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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bb.places.model.Map;
import com.bb.places.service.MapService;
import com.bb.places.util.RegExConstants;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/api/maps")
@Validated
public class MapController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private MapService mapService;

// GET REQUESTS
	@GetMapping(name = "Get All Maps", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map>> getAllMaps() {
		logger.info("Entering getAllMaps...");

		List<Map> mapList = mapService.getAllMaps();

		logger.info("\nMaps: {}", mapList);

		return new ResponseEntity<>(mapList, HttpStatus.OK);
	}

	@GetMapping(name = "Get Public Maps", value = "/pub", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map>> getPublicMaps() {
		logger.info("Entering getPublicMaps...");

		List<Map> mapList = mapService.getPublicMaps();

		logger.info("\nMaps: {}", mapList);

		return new ResponseEntity<>(mapList, HttpStatus.OK);
	}

	@GetMapping(name = "Get All Maps By User ID", value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map>> getAllMapsByUserId(
			@PathVariable @Pattern(regexp = RegExConstants.VALID_USER_ID) String userId) {
		logger.info("Entering getAllMapsByUserId...");

		List<Map> mapList = mapService.getAllMapsByUserId(userId);

		logger.info("\nMaps: {}", mapList);

		return new ResponseEntity<>(mapList, HttpStatus.OK);
	}

	@GetMapping(name = "Get Public Maps By User ID", value = "/pub/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map>> getPublicMapsByUserId(
			@PathVariable @Pattern(regexp = RegExConstants.VALID_USER_ID) String userId) {
		logger.info("Entering getPublicMapsByUserId...");

		List<Map> mapList = mapService.getPublicMapsByUserId(userId);

		logger.info("\nMaps: {}", mapList);

		return new ResponseEntity<>(mapList, HttpStatus.OK);
	}

	@GetMapping(name = "Get Map By ID", value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map> getMapById(@PathVariable @NotBlank String id) {
		logger.info("Entering getMapById...");

		Map mapEnt = mapService.getMapById(id);

		logger.info("\nMap: {}", mapEnt);

		return new ResponseEntity<>(mapEnt, HttpStatus.OK);
	}

	@GetMapping(name = "Get Public Map By ID", value = "/pub/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map> getPublicMapById(@PathVariable @NotBlank String id) {
		logger.info("Entering getPublicMapById...");

		Map mapEnt = mapService.getPublicMapById(id);

		logger.info("\nMap: {}", mapEnt);

		return new ResponseEntity<>(mapEnt, HttpStatus.OK);
	}

// PUT REQUESTS
	@PutMapping(name = "Update Map By ID", value = "/{id}")
	public ResponseEntity<String> updateMapById(@PathVariable @NotBlank String id,
			@Valid @NotNull @RequestBody Map map) {
		logger.info("Entering updateMapById...");

		mapService.updateMap(id, map);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

// POST REQUESTS
	@PostMapping(name = "Create Map")
	public ResponseEntity<String> createMap(@Valid @NotNull @RequestBody Map map) {
		logger.info("Entering createMap...");

		mapService.createMap(map);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@PostMapping(name = "Create Basic Map", value = "/user/{userId}")
	public ResponseEntity<String> createMapBasic(
			@PathVariable @Pattern(regexp = RegExConstants.VALID_USER_ID) String userId,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "pblc", required = true) int pblc) {
		logger.info("Entering createMapBasic...");

		String mapId = userId + "~" + (mapService.getCountMapsByUserId(userId) + 1);

		Map mapEnt = new Map();
		mapEnt.setId(mapId);
		mapEnt.setUserId(userId);
		mapEnt.setName(name);
		mapEnt.setAbout("");
		mapEnt.setPblc(pblc);

		mapService.createMap(mapEnt);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

// DELETE REQUESTS
	@DeleteMapping(name = "Delete Map")
	public ResponseEntity<String> deleteMap(@Valid @NotNull @RequestBody Map map) {
		logger.info("Entering deleteMap...");

		mapService.deleteMap(map);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}