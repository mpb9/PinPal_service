package com.bb.places.controller;

import com.bb.places.model.Icon;
import com.bb.places.model.PinColl;
import com.bb.places.model.User;
import com.bb.places.service.IconService;
import com.bb.places.service.PinCollService;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/icons")
@Validated
public class IconController {
    private static final Logger logger = LoggerFactory.getLogger(IconController.class);

    @Autowired
    private IconService iconService;

    @Autowired
    private PinCollService pinCollService;

    @Autowired
    private UserService userService;

    // GET REQUESTS
    @GetMapping(name = "Get Icon By ID", value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Icon> getIconById(@PathVariable @NotBlank String id) {
        logger.info("Entering getIconById...");

        Icon iconEnt = iconService.getIconById(id);

        logger.info("\nIcon: {}", iconEnt);

        return new ResponseEntity<>(iconEnt, HttpStatus.OK);
    }

    @GetMapping(name = "Get Icon By Pin Collection ID", value = "/pinColl/{pinCollId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Icon> getIconByPinCollId(@PathVariable @NotBlank String pinCollId) {
        logger.info("Entering getIconByPinCollId...");

        Icon iconEnt = iconService.getIconByPinCollId(pinCollId);

        logger.info("\nIcon: {}", iconEnt);

        return new ResponseEntity<>(iconEnt, HttpStatus.OK);
    }

    @GetMapping(name = "Get Icons By User ID", value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Icon>> getIconsByUserId(@PathVariable @NotBlank String userId) {
        logger.info("Entering getIconsByUserId...");

        List<PinColl> pinCollList = pinCollService.getPinCollsByUserId(userId);

        List<Icon> iconList = new ArrayList<>();
        pinCollList.forEach(pinColl -> {
            Icon iconEnt = iconService.getIconById(pinColl.getIconId());
            iconList.add(iconEnt);
        });

        logger.info("\nIcons: {}", iconList);

        return new ResponseEntity<>(iconList, HttpStatus.OK);
    }

    // PUT REQUESTS
    @PutMapping(name = "Update Icon", value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Icon> updateIcon(@PathVariable @NotBlank String id, @Valid @NotNull @RequestBody Icon icon) {
        logger.info("Entering updateIcon...");

        iconService.updateIcon(id, icon);
        Icon iconEnt = iconService.getIconById(icon.getId());

        logger.info("\nIcon: {}", iconEnt);
        return new ResponseEntity<>(iconEnt, HttpStatus.OK);
    }

    // POST REQUESTS
    @PostMapping(name = "Create Icon", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Icon> createIcon(@Valid @NotNull @RequestBody Icon icon) {
        logger.info("Entering createIcon...");

        iconService.createIcon(icon);
        Icon iconEnt = iconService.getIconById(icon.getId());

        logger.info("\nIcon: {}", iconEnt);
        return new ResponseEntity<>(iconEnt, HttpStatus.CREATED);
    }

    // DELETE REQUESTS
    @DeleteMapping(name = "Delete Icon", value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteIcon(@PathVariable @NotBlank String id, @Valid @NotNull @RequestBody User user) {
        logger.info("Entering deleteIcon...");

        userService.validateUser(user);
        iconService.deleteIcon(iconService.getIconById(id));

         logger.info("\nIcon Deleted {}", id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
