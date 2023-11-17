package com.bb.places.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.bb.places.model.Map;
import com.bb.places.repository.MapRepository;

import jakarta.validation.Valid;

@Service
@Validated
public class MapService {

	@Autowired
	private MapRepository mapRepository;

	public List<Map> getAllMaps() {
		return mapRepository.findAllByOrderById();
	}

	public List<Map> getPublicMaps() {
		return mapRepository.findByPblc(1);
	}

	public Map getMapById(int id) {
		return mapRepository.findById(id).get();
	}

	public List<Map> getAllMapsByUserId(String userId) {
		return mapRepository.findByUserId(userId);
	}

	public List<Map> getPublicMapsByUserId(String userId) {
		return mapRepository.findByUserIdAndPblc(userId, 1);
	}

	public void updateMap(int id, @Valid Map map) {
		Map rtndMap = getMapById(id);
		rtndMap.setUserId(map.getUserId());
		rtndMap.setName(map.getName());
		rtndMap.setPblc(map.getPblc());

		mapRepository.save(rtndMap);
	}

	public void createMap(@Valid Map map) {
		mapRepository.save(map);
	}

	public void deleteMap(@Valid Map map) {
		mapRepository.delete(map);
	}

	public void deleteMapById(int id) {
		Map map = getMapById(id);
		mapRepository.delete(map);
	}

}
