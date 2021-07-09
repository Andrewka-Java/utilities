/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.service.impl;

import com.sun.xml.internal.ws.util.UtilException;
import com.utilities.model.Utility;
import com.utilities.repository.UtilityRepository;
import com.utilities.service.UtilityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@AllArgsConstructor
public class UtilityServiceImpl implements UtilityService {

    public static final String UTILITY_NOT_FOUND_MESSAGE_PATTERN = "Utility with id [%s] not found";

    private final UtilityRepository utilityRepository;

    @Override
    public Utility findById(final int id) {
        return utilityRepository.findById(id)
                .orElseThrow(() -> new UtilException(format(UTILITY_NOT_FOUND_MESSAGE_PATTERN, id)));
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
