/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.controller;

import com.utilities.model.Utility;
import com.utilities.service.UtilityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.utilities.config.Constant.APP_VERSION_URL;

@RestController
@RequestMapping(value = "api/" +  APP_VERSION_URL + "/utilities")
@AllArgsConstructor
public class UtilityController {

    private final UtilityService utilityService;

    @GetMapping("/{id}")
    public Utility findUtility(@PathVariable("id") final int id) {
        return utilityService.findById(id);
    }

    @GetMapping
    public List<Utility> findUtilities() {
        return utilityService.findAll();
    }

    @PostMapping
    public Utility addUtility(@RequestBody final Utility utility) {
        return utilityService.add(utility);
    }

    @PutMapping("/id")
    public Utility updateUtility(@RequestBody final Utility utility) {
        return utilityService.update(utility);
    }


}
