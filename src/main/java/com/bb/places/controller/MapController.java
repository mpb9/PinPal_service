package com.bb.places.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.places.model.Map;
import com.bb.places.service.MapService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/map")
@Validated
public class MapController {

	@Autowired
	private MapService mapService;

	@GetMapping(name = "Get All Maps", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map>> getAllMaps() {
		List<Map> mapList = mapService.getAllMaps();
		return new ResponseEntity<>(mapList, HttpStatus.OK);
	}

	@GetMapping(name = "Get Public Maps By User ID", value = "/public/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map>> getPublicUserMaps(@PathVariable String userId) {
		List<Map> mapList = mapService.getPublicMapsByUserId(userId);
		return new ResponseEntity<>(mapList, HttpStatus.OK);
	}

	@PostMapping(name = "Create Map")
	public ResponseEntity<String> createMap(@Valid @RequestBody Map map) {
		mapService.createMap(map);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

}
