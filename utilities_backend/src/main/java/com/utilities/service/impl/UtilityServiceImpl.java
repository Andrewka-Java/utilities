/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.service.impl;

import com.utilities.model.Utility;
import com.utilities.repository.UtilityRepository;
import com.utilities.service.UtilityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UtilityServiceImpl implements UtilityService {

    private final UtilityRepository utilityRepository;

    @Override
    public Utility findById(final int id) {
        return utilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utility with id [" + id + "] not found"));
    }

    @Override
    public List<Utility> findAll() {
        return utilityRepository.findAll();
    }

    @Override
    public Utility add(final Utility utility) {
        return utilityRepository.save(utility);
    }

    @Override
    public Utility update(final Utility utility) {
        return utilityRepository.save(utility);
    }

    @Override
    public void delete(final int id) {
        utilityRepository.deleteById(id);
    }
}
