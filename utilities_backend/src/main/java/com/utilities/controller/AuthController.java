/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.utilities.config.Constant.APP_VERSION_URL;


@RestController
@RequestMapping(value = "/" + APP_VERSION_URL + "/auth/token")
public class AuthController {



}
