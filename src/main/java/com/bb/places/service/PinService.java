package com.bb.places.service;

import com.bb.places.model.Pin;
import com.bb.places.repository.PinRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class PinService {
    private static final Logger logger = LoggerFactory.getLogger(PinService.class);

    @Autowired
    private PinRepository pinRepository;

    // GET REQUESTS
    public Pin getPinById(@NotBlank String id) {
        logger.info("Entering getPinById...");
        return pinRepository.findById(id).get();
    }

    public Pin getPinByPlaceIdAndPinCollId(@NotBlank String placeId, @NotBlank String pinCollId) {
        logger.info("Entering getPinByPlaceIdAndPinCollId...");
        return pinRepository.findByPlaceIdAndPinCollId(placeId, pinCollId);
    }

    public List<Pin> getPinsByPinCollId(@NotBlank String pinCollId) {
        logger.info("Entering getPinsByPinCollId...");
        return pinRepository.findByPinCollId(pinCollId);
    }

    // PUT REQUESTS
    @Transactional
    public void updatePin(@NotBlank String id, @Valid @NotNull Pin pin){
        logger.info("Entering updatePin...");
        Pin rtndPin = pinRepository.findById(id).get();
        rtndPin.setId(pin.getId());
        rtndPin.setPlaceId(pin.getPlaceId());
        rtndPin.setPinCollId(pin.getPinCollId());
        rtndPin.setName(pin.getName());
        rtndPin.setAbout(pin.getAbout());
        rtndPin.setPhoto(pin.getPhoto());
        pinRepository.save(rtndPin);
    }

    // POST REQUESTS
    @Transactional
    public void createPin(@Valid @NotNull Pin pin){
        logger.info("Entering createPin...");
        pinRepository.save(pin);
    }

    // DELETE REQUESTS
    @Transactional
    public void deletePin(@Valid @NotNull Pin pin){
        logger.info("Entering deletePin...");
        pinRepository.delete(pin);
    }


}
