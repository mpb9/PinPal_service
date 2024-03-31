package com.bb.places.controller;

import com.bb.places.model.PlaceDetails;
import com.bb.places.model.User;
import com.bb.places.service.PlaceDetailsService;
import com.bb.places.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/place-details")
@Validated
public class PlaceDetailsController {
    private static final Logger logger = LoggerFactory.getLogger(PlaceDetailsController.class);

    @Autowired
    private PlaceDetailsService placeDetailsService;
    @Autowired
    private UserService userService;

    // GET REQUESTS
    @GetMapping(name = "Get Place Details By Id", value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDetails> getPlaceDetailsById(
            @PathVariable @NotBlank String id) {
        logger.info("Entering getPlaceDetailsById...");

        PlaceDetails placeDetails = placeDetailsService.getPlaceDetailsByPlaceId(id);

        logger.info("\nPlace Details: {}", placeDetails);
        return new ResponseEntity<>(placeDetails, HttpStatus.OK);
    }

    @GetMapping(name = "Get Place Details By Place Id", value = "place/{placeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDetails> getPlaceDetailsByPlaceId(
            @PathVariable @NotBlank String placeId) {
        logger.info("Entering getPlaceDetailsByPlaceId...");

        PlaceDetails placeDetails = placeDetailsService.getPlaceDetailsByPlaceId(placeId);

        logger.info("\nPlace Details: {}", placeDetails);
        return new ResponseEntity<>(placeDetails, HttpStatus.OK);
    }

    // PUT REQUESTS
    @PutMapping(name = "Update Place Details By Place Id", value = "/{placeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDetails> updatePlaceDetailsByPlaceId(
            @PathVariable @NotBlank String placeId,
            @RequestBody @Valid @NotNull PlaceDetails placeDetails) {
        logger.info("Entering updatePlaceDetails...");

        placeDetailsService.updatePlaceDetailsByPlaceId(placeId, placeDetails);
        PlaceDetails placeDetailsEnt = placeDetailsService.getPlaceDetailsByPlaceId(placeDetails.getPlaceId());

        logger.info("\nPlace Details: {}", placeDetailsEnt);
        return new ResponseEntity<>(placeDetailsEnt, HttpStatus.OK);
    }

    // POST REQUESTS
    @PostMapping(name = "Create Place Details", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaceDetails> createPlaceDetails(
            @RequestBody @Valid @NotNull PlaceDetails placeDetails) {
        logger.info("Entering createPlaceDetails...");

        placeDetailsService.createPlaceDetails(placeDetails);
        PlaceDetails placeDetailsEnt = placeDetailsService.getPlaceDetailsByPlaceId(placeDetails.getPlaceId());

        logger.info("\nPlace Details: {}", placeDetailsEnt);
        return new ResponseEntity<>(placeDetailsEnt, HttpStatus.CREATED);
    }

    // DELETE REQUESTS
    @DeleteMapping(name = "Delete Place Details By Place Id", value = "/{placeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletePlaceDetails(
            @PathVariable @NotBlank String placeId,
            @RequestBody @Valid @NotNull User user) {
        logger.info("Entering deletePlaceDetails...");

        userService.validateUser(user);
        placeDetailsService.deletePlaceDetails(placeDetailsService.getPlaceDetailsByPlaceId(placeId));

        logger.info("\nPlace Details Deleted: {}", placeId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
