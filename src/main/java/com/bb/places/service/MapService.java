package com.bb.places.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.bb.places.model.Map;
import com.bb.places.repository.MapRepository;
import com.bb.places.util.RegExConstants;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Service
@Validated
public class MapService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private MapRepository mapRepository;

	public List<Map> getAllMaps() {
		logger.info("Entering getAllMaps...");

		return mapRepository.findAllByOrderById();
	}

	public List<Map> getPublicMaps() {
		logger.info("Entering getPublicMaps...");

		return mapRepository.findByPblc(1);
	}

	public List<Map> getAllMapsByUserId(@Pattern(regexp = RegExConstants.VALID_USER_ID) String userId) {
		logger.info("Entering getAllMapsByUserId...");

		return mapRepository.findByUserId(userId);
	}

	public List<Map> getPublicMapsByUserId(@Pattern(regexp = RegExConstants.VALID_USER_ID) String userId) {
		logger.info("Entering getPublicMapsByUserId...");

		return mapRepository.findByUserIdAndPblc(userId, 1);
	}

	public Map getMapById(@NotBlank String id) {
		logger.info("Entering getMapById...");

		return mapRepository.findById(id).get();
	}

	public Map getPublicMapById(@NotBlank String id) {
		logger.info("Entering getPublicMapById...");

		return mapRepository.findByIdAndPblc(id, 1);
	}

	public int getCountMapsByUserId(@Pattern(regexp = RegExConstants.VALID_USER_ID) String userId) {
		logger.info("Entering getCountMapsByUserId...");

		return mapRepository.countByUserId(userId);
	}

	@Transactional
	public void updateMap(@NotBlank String id, @Valid Map map) {
		logger.info("Entering updateMap...");

		Map rtndMap = getMapById(id);
		rtndMap.setUserId(map.getUserId());
		rtndMap.setName(map.getName());
		rtndMap.setPblc(map.getPblc());

		mapRepository.save(rtndMap);
	}

	@Transactional
	public void createMap(@Valid Map map) {
		logger.info("Entering createMap...");

		mapRepository.save(map);
	}

	@Transactional
	public void deleteMap(@Valid Map map) {
		logger.info("Entering deleteMap...");

		mapRepository.delete(map);
	}

}
