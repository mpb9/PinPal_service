package com.bb.places.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.places.model.Map;
import com.bb.places.service.MapService;

@RestController
@RequestMapping("/api/map")
@Validated
public class MapController {

	@Autowired
	MapService mapService;

	@GetMapping("")
	public List<Map> getAllMaps() {
		return mapService.getAllMaps();
	}

	@PostMapping("")
	public void createMap(Map map) {
		mapService.createMap(map);
	}

}
