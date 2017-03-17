package com.birthdaymanager.facade;

import com.birthdaymanager.dto.User;
import com.birthdaymanager.services.RegistrationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by umesh.soni on 3/16/2017.
 */
@Component
public class RegistrationFacade {

    private RegistrationServices registrationServices;

    @Autowired
    public RegistrationFacade(RegistrationServices registrationServices){
        this.registrationServices = registrationServices;
    }

    public User validateRegistration(User user){
        //validation code
        if(user == null){
            user = new User();
        }
        return user;
    }

    public User saveUser(User user){
        //save user
        user = registrationServices.saveValidUser(user);
        return user;
    }
}
