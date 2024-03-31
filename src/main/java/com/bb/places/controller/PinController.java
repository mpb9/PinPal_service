package com.bb.places.controller;

import com.bb.places.model.Pin;
import com.bb.places.model.User;
import com.bb.places.service.PinService;
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
@RequestMapping("/api/pins")
@Validated
public class PinController {
    private static final Logger logger = LoggerFactory.getLogger(PinController.class);

    @Autowired
    private PinService pinService;

    @Autowired
    private UserService userService;

    // GET REQUESTS
    @GetMapping(name = "Get Pin By ID", value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pin> getPinById(@PathVariable @NotBlank String id) {
        logger.info("Entering getPinById...");

        Pin pin = pinService.getPinById(id);

        logger.info("\nPin: {}", pin);

        return new ResponseEntity<>(pin, HttpStatus.OK);
    }

    @GetMapping(name = "Get Pin By Place ID and Pin Collection ID", value = "/pinColl/{pinCollId}/place/{placeId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pin> getPinByPlaceIdAndPinCollId(
            @PathVariable @NotBlank String pinCollId,
            @PathVariable @NotBlank String placeId) {
        logger.info("Entering getPinByPlaceIdAndPinCollId...");

        Pin pin = pinService.getPinByPlaceIdAndPinCollId(placeId, pinCollId);

        logger.info("\nPin: {}", pin);

        return new ResponseEntity<>(pin, HttpStatus.OK);
    }

    @GetMapping(name = "Get Pins By Pin Collection ID", value = "/pinColl/{pinCollId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pin>> getPinsByPinCollId(@PathVariable @NotBlank String pinCollId) {
        logger.info("Entering getPinsByPinCollId...");

        List<Pin> pinList = pinService.getPinsByPinCollId(pinCollId);

        logger.info("\nPins: {}", pinList);

        return new ResponseEntity<>(pinList, HttpStatus.OK);
    }

    // PUT REQUESTS
    @PutMapping(name = "Update Pin", value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePin(@PathVariable @NotBlank String id, @Valid @NotNull @RequestBody Pin pin) {
        logger.info("Entering updatePin...");

        pinService.updatePin(id, pin);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // POST REQUESTS
    @PostMapping(name = "Create Pin", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createPin(@Valid @NotNull @RequestBody Pin pin) {
        logger.info("Entering createPin...");

        pinService.createPin(pin);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    // DELETE REQUESTS
    @DeleteMapping(name = "Delete Pin", value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePin(@PathVariable @NotBlank String id,
                                            @Valid @NotNull @RequestBody User user) {
        logger.info("Entering deletePin...");

        userService.validateUser(user);

        pinService.deletePin(pinService.getPinById(id));

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
