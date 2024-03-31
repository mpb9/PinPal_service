package com.bb.places.service;

import com.bb.places.model.Guide;
import com.bb.places.repository.GuideRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class GuideService {

	private static final Logger logger = LoggerFactory.getLogger(GuideService.class);

	@Autowired
	private GuideRepository guideRepository;

	// GET REQUESTS
	public List<Guide> getAllGuides() {
		logger.info("Entering getAllGuides...");

		return guideRepository.findAllByOrderById();
	}

	public List<Guide> getPublicGuides() {
		logger.info("Entering getPublicGuides...");

		return guideRepository.findByPblc(1);
	}

	public List<Guide> getAllGuidesByUserId(@NotBlank String userId) {
		logger.info("Entering getAllGuidesByUserId...");

		return guideRepository.findByUserId(userId);
	}

	public List<Guide> getPublicGuidesByUserId(@NotBlank String userId) {
		logger.info("Entering getPublicGuidesByUserId...");

		return guideRepository.findByUserIdAndPblc(userId, 1);
	}

	public Guide getGuideById(@NotBlank String id) {
		logger.info("Entering getGuideById...");

        return guideRepository.findById(id).get();
    }

	public Guide getPublicGuideById(@NotBlank String id) {
		logger.info("Entering getPublicGuideById...");

		return guideRepository.findByIdAndPblc(id, 1);
	}

	public int getCountGuidesByUserId(@NotBlank String userId) {
		logger.info("Entering getCountGuidesByUserId...");

		return guideRepository.countByUserId(userId);
	}

	// PUT REQUESTS
	@Transactional
	public void updateGuide(@NotBlank String id, @Valid Guide guide) {
		logger.info("Entering updateGuide...");

		Guide rtndGuide = getGuideById(id);
		rtndGuide.setUserId(guide.getUserId());
		rtndGuide.setName(guide.getName());
		rtndGuide.setPblc(guide.getPblc());

		guideRepository.save(rtndGuide);
	}

	// POST REQUESTS
	@Transactional
	public void createGuide(@Valid Guide guide) {
		logger.info("Entering createGuide...");

		guideRepository.save(guide);
	}

	// DELETE REQUESTS
	@Transactional
	public void deleteGuide(@Valid Guide guide) {
		logger.info("Entering deleteGuide...");

		guideRepository.delete(guide);
	}

}
