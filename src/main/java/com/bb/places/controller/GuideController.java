package com.bb.places.controller;

import com.bb.places.model.Guide;
import com.bb.places.model.User;
import com.bb.places.service.GuideService;
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

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/guides")
@Validated
public class GuideController {

    private static final Logger logger = LoggerFactory.getLogger(GuideController.class);

    @Autowired
    private GuideService guideService;

    @Autowired
    private UserService userService;

    // GET REQUESTS
    @GetMapping(name = "Get All Guides", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guide>> getAllGuides() {
        logger.info("Entering getAllGuides...");

        List<Guide> GuideList = guideService.getAllGuides();

        logger.info("\nGuideList: {}", GuideList);
        return new ResponseEntity<>(GuideList, HttpStatus.OK);
    }

    @GetMapping(name = "Get Public Guides", value = "/pblc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guide>> getPublicGuides() {
        logger.info("Entering getPublicGuides...");

        List<Guide> GuideList = guideService.getPublicGuides();

        logger.info("\nGuideList: {}", GuideList);
        return new ResponseEntity<>(GuideList, HttpStatus.OK);
    }

    @GetMapping(name = "Get All Guides By User ID", value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guide>> getGuidesByUserId(
            @PathVariable @NotBlank String userId) {
        logger.info("Entering getGuidesByUserId...");

        List<Guide> GuideList = guideService.getGuidesByUserId(userId);

        logger.info("\nGuideList: {}", GuideList);
        return new ResponseEntity<>(GuideList, HttpStatus.OK);
    }

    @GetMapping(name = "Get Public Guides By User ID", value = "/pblc/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guide>> getPublicGuidesByUserId(
            @PathVariable @NotBlank String userId) {
        logger.info("Entering getPublicGuidesByUserId...");

        List<Guide> GuideList = guideService.getPublicGuidesByUserId(userId);

        logger.info("\nGuideList: {}", GuideList);
        return new ResponseEntity<>(GuideList, HttpStatus.OK);
    }

    @GetMapping(name = "Get Guide By ID", value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guide> getGuideById(@PathVariable @NotBlank String id) {
        logger.info("Entering getGuideById...");

        Guide guideEnt = guideService.getGuideById(id);

        logger.info("\nguideEnt: {}", guideEnt);

        return new ResponseEntity<>(guideEnt
                , HttpStatus.OK);
    }

    @GetMapping(name = "Get Public Guide By ID", value = "/pblc/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guide> getPublicGuideById(@PathVariable @NotBlank String id) {
        logger.info("Entering getPublicGuideById...");

        Guide guideEnt
                = guideService.getPublicGuideById(id);

        logger.info("\nguideEnt: {}", guideEnt
        );

        return new ResponseEntity<>(guideEnt
                , HttpStatus.OK);
    }

    // PUT REQUESTS
    @PutMapping(name = "Update Guide", value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guide> updateGuide(@PathVariable @NotBlank String id,
                                                  @Valid @NotNull @RequestBody Guide guide) {
        logger.info("Entering updateGuide...");

        guideService.updateGuide(id, guide);
        Guide guideEnt = guideService.getGuideById(guide.getId());

        logger.info("\nguideEnt: {}", guideEnt);
        return new ResponseEntity<>(guideEnt, HttpStatus.OK);
    }

    // POST REQUESTS
    @PostMapping(name = "Create Guide", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guide> createGuide(@Valid @NotNull @RequestBody Guide guide) {
        logger.info("Entering createGuide...");

        guideService.createGuide(guide);
        Guide guideEnt = guideService.getGuideById(guide.getId());

        logger.info("\nguideEnt: {}", guideEnt);
        return new ResponseEntity<>(guideEnt, HttpStatus.CREATED);
    }

    // DELETE REQUESTS
    @DeleteMapping(name = "Delete Guide", value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteGuide(@PathVariable @NotBlank String id,
                                              @Valid @NotNull @RequestBody User user) {
        logger.info("Entering deleteGuide...");

        userService.validateUser(user);
        guideService.deleteGuide(guideService.getGuideById(id));

        logger.info("\nGuide Deleted: {}", id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}