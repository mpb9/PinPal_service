package com.bb.places.repository;


import com.bb.places.model.Icon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IconRepository extends CrudRepository<Icon, String> {
    
    Icon findByPinCollId(String pinCollId);


    List<Icon> findAllByOrderById();
}