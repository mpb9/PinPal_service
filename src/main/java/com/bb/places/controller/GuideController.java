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
    private GuideService GuideService;

    @Autowired
    private UserService userService;

    // GET REQUESTS
    @GetMapping(name = "Get All Guides", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guide>> getAllGuides() {
        logger.info("Entering getAllGuides...");

        List<Guide> GuideList = GuideService.getAllGuides();

        logger.info("\nGuides: {}", GuideList);

        return new ResponseEntity<>(GuideList, HttpStatus.OK);
    }

    @GetMapping(name = "Get Public Guides", value = "/pblc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guide>> getPublicGuides() {
        logger.info("Entering getPublicGuides...");

        List<Guide> GuideList = GuideService.getPublicGuides();

        logger.info("\nGuides: {}", GuideList);

        return new ResponseEntity<>(GuideList, HttpStatus.OK);
    }

    @GetMapping(name = "Get All Guides By User ID", value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guide>> getAllGuidesByUserId(
            @PathVariable @NotBlank String userId) {
        logger.info("Entering getAllGuidesByUserId...");

        List<Guide> GuideList = GuideService.getAllGuidesByUserId(userId);

        logger.info("\nGuides: {}", GuideList);

        return new ResponseEntity<>(GuideList, HttpStatus.OK);
    }

    @GetMapping(name = "Get Public Guides By User ID", value = "/pblc/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guide>> getPublicGuidesByUserId(
            @PathVariable @NotBlank String userId) {
        logger.info("Entering getPublicGuidesByUserId...");

        List<Guide> GuideList = GuideService.getPublicGuidesByUserId(userId);

        logger.info("\nGuides: {}", GuideList);

        return new ResponseEntity<>(GuideList, HttpStatus.OK);
    }

    @GetMapping(name = "Get Guide By ID", value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guide> getGuideById(@PathVariable @NotBlank String id) {
        logger.info("Entering getGuideById...");

        Guide guideEnt = GuideService.getGuideById(id);

        logger.info("\nGuide: {}", guideEnt);

        return new ResponseEntity<>(guideEnt
                , HttpStatus.OK);
    }

    @GetMapping(name = "Get Public Guide By ID", value = "/pblc/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guide> getPublicGuideById(@PathVariable @NotBlank String id) {
        logger.info("Entering getPublicGuideById...");

        Guide guideEnt
                = GuideService.getPublicGuideById(id);

        logger.info("\nGuide: {}", guideEnt
        );

        return new ResponseEntity<>(guideEnt
                , HttpStatus.OK);
    }

    // PUT REQUESTS
    @PutMapping(name = "Update Guide By ID", value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateGuide(@PathVariable @NotBlank String id,
                                                  @Valid @NotNull @RequestBody Guide guide) {
        logger.info("Entering updateGuide...");

        GuideService.updateGuide(id, guide);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // POST REQUESTS
    @PostMapping(name = "Create Guide", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createGuide(@Valid @NotNull @RequestBody Guide guide) {
        logger.info("Entering createGuide...");

        GuideService.createGuide(guide);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping(name = "Create Basic Guide", value = "/user/{userId}")
    public ResponseEntity<String> createGuideBasic(
            @PathVariable @NotBlank String userId,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "pblc", required = true) int pblc) {
        logger.info("Entering createGuideBasic...");

        String GuideId = userId + "~" + (GuideService.getCountGuidesByUserId(userId) + 1);

        Guide guideEnt = new Guide();
        guideEnt.setId(GuideId);
        guideEnt.setUserId(userId);
        guideEnt.setName(name);
        guideEnt.setAbout("");
        guideEnt.setPblc(pblc);

        GuideService.createGuide(guideEnt
        );
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    // DELETE REQUESTS
    @DeleteMapping(name = "Delete Guide", value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteGuide(@PathVariable @NotBlank String id,
                                              @Valid @NotNull @RequestBody User user) {
        logger.info("Entering deleteGuide...");

        userService.validateUser(user);

        GuideService.deleteGuide(GuideService.getGuideById(id));
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}