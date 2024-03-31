package com.bb.places.service;

import com.bb.places.model.Icon;
import com.bb.places.repository.IconRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class IconService {
    private static final Logger logger = LoggerFactory.getLogger(IconService.class);

    @Autowired
    private IconRepository iconRepository;

    // GET REQUESTS
    public Icon getIconById(@NotBlank String id) {
        logger.info("Entering getIconById...");

        return iconRepository.findById(id).get();
    }

    public Icon getIconByPinCollId(String pinCollId) {
        logger.info("Entering getIconByPinCollId...");

        return iconRepository.findByPinCollId(pinCollId);
    }

    // PUT REQUESTS
    @Transactional
    public void updateIcon(@NotBlank String id, @Valid Icon icon){
        logger.info("Entering updateIcon...");

        Icon iconToUpdate = iconRepository.findById(id).get();

        iconToUpdate.setPinCollId(icon.getPinCollId());
        iconToUpdate.setName(icon.getName());
        iconToUpdate.setColor(icon.getColor());
        iconToUpdate.setStyle(icon.getStyle());

        iconRepository.save(iconToUpdate);
    }

    // POST REQUESTS
    @Transactional
    public void createIcon(@Valid Icon icon){
        logger.info("Entering createIcon...");

        iconRepository.save(icon);
    }

    // DELETE REQUESTS
    @Transactional
    public void deleteIcon(@Valid Icon icon){
        logger.info("Entering deleteIcon...");

        iconRepository.delete(icon);
    }

}
