package com.birthdaymanager.controller;

import com.birthdaymanager.dto.Registration;
import com.birthdaymanager.dto.User;
import com.birthdaymanager.facade.RegistrationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umesh.soni on 3/14/2017.
 */
@RestController
public class UserRegistrationController {

    private RegistrationFacade registrationFacade;

    @Autowired
    public UserRegistrationController(RegistrationFacade registrationFacade){
        this.registrationFacade = registrationFacade;
    }


    @RequestMapping(value = "/registor" , method = RequestMethod.GET)       //get request
    public String registor() {
        return "registor from Spring Boot!";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST, consumes = "application/json", produces = "application/json")       //post request
    public ResponseEntity<User> login(@RequestBody User user) {
        user = registrationFacade.validateRegistration(user);
        user = registrationFacade.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
