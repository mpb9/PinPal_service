package com.bb.places.service;

import com.bb.places.model.Icon;
import com.bb.places.repository.IconRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    public Icon getIconByPinCollId(@NotBlank String pinCollId) {
        logger.info("Entering getIconByPinCollId...");

        return iconRepository.findByPinCollId(pinCollId);
    }

    // PUT REQUESTS
    @Transactional
    public void updateIcon(@NotBlank String id, @Valid @NotNull Icon icon){
        logger.info("Entering updateIcon...");

        Icon iconEnt = iconRepository.findById(id).get();
        iconEnt.setId(icon.getId());
        iconEnt.setPinCollId(icon.getPinCollId());
        iconEnt.setName(icon.getName());
        iconEnt.setColor(icon.getColor());
        iconEnt.setStyle(icon.getStyle());

        iconRepository.save(iconEnt);
    }

    // POST REQUESTS
    @Transactional
    public void createIcon(@Valid @NotNull Icon icon){
        logger.info("Entering createIcon...");
        iconRepository.save(icon);
    }

    // DELETE REQUESTS
    @Transactional
    public void deleteIcon(@Valid @NotNull Icon icon){
        logger.info("Entering deleteIcon...");
        iconRepository.delete(icon);
    }
}
