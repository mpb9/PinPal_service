package com.bb.places.service;

import com.bb.places.model.PlaceDetails;
import com.bb.places.repository.PlaceDetailsRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.NotBlank;

@Service
@Validated
public class PlaceDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(PlaceDetailsService.class);

    @Autowired
    private PlaceDetailsRepository placeDetailsRepository;

    // GET REQUESTS
    public PlaceDetails getPlaceDetailsByPlaceId(@NotBlank String placeId) {
        logger.info("Entering getPlaceDetailsById...");
        return placeDetailsRepository.findById(placeId).get();
    }

    // PUT REQUESTS
    @Transactional
    public void updatePlaceDetailsByPlaceId(@NotBlank String placeId, @Valid @NotNull PlaceDetails placeDetails) {
        logger.info("Entering updatePlaceDetails...");
        PlaceDetails rtndPlaceDetails = getPlaceDetailsByPlaceId(placeId);
        rtndPlaceDetails.setPlaceId(placeDetails.getPlaceId());
        rtndPlaceDetails.setName(placeDetails.getName());
        rtndPlaceDetails.setLat(placeDetails.getLat());
        rtndPlaceDetails.setLng(placeDetails.getLng());
        rtndPlaceDetails.setAddress(placeDetails.getAddress());
        rtndPlaceDetails.setCountry(placeDetails.getCountry());
        rtndPlaceDetails.setWebsite(placeDetails.getWebsite());
        rtndPlaceDetails.setPhone(placeDetails.getPhone());
        rtndPlaceDetails.setBusinessStatus(placeDetails.getBusinessStatus());
        rtndPlaceDetails.setOpeningHours(placeDetails.getOpeningHours());
        rtndPlaceDetails.setRating(placeDetails.getRating());
        rtndPlaceDetails.setRatingsCount(placeDetails.getRatingsCount());
        rtndPlaceDetails.setSummary(placeDetails.getSummary());
        rtndPlaceDetails.setTypes(placeDetails.getTypes());
        rtndPlaceDetails.setPhotos(placeDetails.getPhotos());
        placeDetailsRepository.save(placeDetails);
    }

    // POST REQUESTS
    @Transactional
    public void createPlaceDetails(@Valid @NotNull PlaceDetails placeDetails) {
        logger.info("Entering createPlaceDetails...");
        placeDetailsRepository.save(placeDetails);
    }

    // DELETE REQUESTS
    @Transactional
    public void deletePlaceDetails(@Valid @NotNull PlaceDetails placeDetails) {
        logger.info("Entering deletePlaceDetails...");
        placeDetailsRepository.delete(placeDetails);
    }

    @Transactional
    public void deletePlaceDetailsByPlaceId(@NotBlank String placeId) {
        logger.info("Entering deletePlaceDetails...");
        placeDetailsRepository.deleteById(placeId);
    }

}
