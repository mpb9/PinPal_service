package com.bb.places.controller;

import com.bb.places.model.PinColl;
import com.bb.places.model.User;
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

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/pin-colls")
@Validated
public class PinCollController {
    private static final Logger logger = LoggerFactory.getLogger(PinCollController.class);

    @Autowired
    private PinCollService pinCollService;

    @Autowired
    private UserService userService;

    // GET REQUESTS
    @GetMapping(name = "Get Pin Collections by User ID", value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PinColl>> getPinCollsByUserId(@PathVariable @NotBlank String userId) {
        logger.info("Entering getPinCollsByUserId...");

        List<PinColl> pinCollList = pinCollService.getPinCollsByUserId(userId);

        logger.info("\nPin Collections: {}", pinCollList);
        return new ResponseEntity<>(pinCollList, HttpStatus.OK);
    }

    @GetMapping(name = "Get Pin Collections by Guide ID", value = "/guide/{guideId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PinColl>> getPinCollsByGuideId(@PathVariable @NotBlank String guideId){
        logger.info("Entering getPinCollsByGuideId...");

        List<PinColl> pinCollList = pinCollService.getPinCollsByGuideId(guideId);

        logger.info("\nPin Collections: {}", pinCollList);
        return new ResponseEntity<>(pinCollList, HttpStatus.OK);
    }

    @GetMapping(name = "Get Pin Collection by ID", value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PinColl> getPinCollById(@PathVariable @NotBlank String id){
        logger.info("Entering getPinCollById...");

        PinColl pinCollEnt = pinCollService.getPinCollById(id);

        logger.info("\nPin Collection: {}", pinCollEnt);
        return new ResponseEntity<>(pinCollEnt, HttpStatus.OK);
    }

    // PUT REQUESTS
    @PutMapping(name = "Update Pin Collection", value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PinColl> updatePinColl(@PathVariable @NotBlank String id, @Valid @NotNull @RequestBody PinColl pinColl){
        logger.info("Entering updatePinColl...");

        pinCollService.updatePinColl(id, pinColl);
        PinColl pinCollEnt = pinCollService.getPinCollById(pinColl.getId());

        logger.info("Pin Collection updated: {}", pinCollEnt);
        return new ResponseEntity<>(pinCollEnt, HttpStatus.OK);
    }

    // POST REQUESTS
    @PostMapping(name = "Create Pin Collection", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PinColl> createPinColl(@Valid @NotNull @RequestBody PinColl pinColl){
        logger.info("Entering createPinColl...");

        pinCollService.createPinColl(pinColl);
        PinColl pinCollEnt = pinCollService.getPinCollById(pinColl.getId());

        logger.info("Pin Collection created: {}", pinCollEnt);
        return new ResponseEntity<>(pinCollEnt, HttpStatus.CREATED);
    }

    // DELETE REQUESTS
    @DeleteMapping(name = "Delete Pin Collection", value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletePinColl(@PathVariable @NotBlank String id, @Valid @NotNull @RequestBody User user){
        logger.info("Entering deletePinColl...");

        userService.validateUser(user);
        pinCollService.deletePinColl(pinCollService.getPinCollById(id));

        logger.info("Pin Collection deleted: {}", id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
