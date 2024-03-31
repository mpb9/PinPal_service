package com.bb.places.service;


import com.bb.places.model.PinColl;
import com.bb.places.repository.PinCollRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class PinCollService {
    private static final Logger logger = LoggerFactory.getLogger(PinCollService.class);

    @Autowired
    private PinCollRepository pinCollRepository;

    public List<PinColl> getPinCollsByUserId(@NotBlank String userId) {
        logger.info("Entering getPinCollsByUserId...");
        return pinCollRepository.findByUserId(userId);
    }

    public List<PinColl> getPinCollsByGuideId(@NotBlank String guideId) {
        logger.info("Entering getPinCollsByGuideId...");
        return pinCollRepository.findByGuideId(guideId);
    }

    public PinColl getPinCollById(@NotBlank String id) {
        logger.info("Entering getPinCollById...");
        //PinColl pinCollEnt = pinCollRepository.findById(id).isPresent() ? pinCollRepository.findById(id).get() : null;
        return pinCollRepository.findById(id).get();
    }

    @Transactional
    public void updatePinColl(@NotBlank String id, @Valid @NotNull PinColl pinColl){
        logger.info("Entering updatePinColl...");
        PinColl rtndPinColl = getPinCollById(id);
        rtndPinColl.setUserId(pinColl.getUserId());
        rtndPinColl.setGuideId(pinColl.getGuideId());
        rtndPinColl.setIconId(pinColl.getIconId());
        rtndPinColl.setName(pinColl.getName());
        pinCollRepository.save(rtndPinColl);
    }

    @Transactional
    public void createPinColl(@Valid @NotNull PinColl pinColl){
        logger.info("Entering createPinColl...");
        pinCollRepository.save(pinColl);
    }

    @Transactional
    public void deletePinColl(@Valid @NotNull PinColl pinColl){
        logger.info("Entering deletePinColl...");
        pinCollRepository.delete(pinColl);
    }

}
