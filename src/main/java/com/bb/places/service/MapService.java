package com.bb.places.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bb.places.model.Map;
import com.bb.places.repository.MapRepository;

@Service
public class MapService {

	@Autowired
	MapRepository mapRepository;

	public List<Map> getAllMaps() {
		return mapRepository.findAll();
	}

	public Map getMapById(Integer id) {
		return mapRepository.findById(id).get();
	}

	public void createMap(Map map) {
		mapRepository.save(map);
	}

	public void deleteMap(Map map) {
		mapRepository.delete(map);
	}

	public void deleteMapById(Integer id) {
		Map map = getMapById(id);
		mapRepository.delete(map);
	}

	public void updateMap(Integer id, Map map) {
		Map rtndMap = getMapById(id);
		rtndMap.setUserId(map.getUserId());
		rtndMap.setTitle(map.getTitle());
		rtndMap.setPblc(map.getPblc());

		mapRepository.save(rtndMap);
	}

}
