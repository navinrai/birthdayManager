package com.birthdaymanager.servicesImpl;

import com.birthdaymanager.dto.User;
import com.birthdaymanager.repository.RegistrationRepository;
import com.birthdaymanager.services.RegistrationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by umesh.soni on 3/16/2017.
 */
@Service
@Transactional(value = "hwTransactionManager", readOnly = true)
public class RegistrationServicesImpl implements RegistrationServices {


    private RegistrationRepository registrationRepository;

    @Autowired
     public RegistrationServicesImpl(RegistrationRepository registrationRepository){
         this.registrationRepository = registrationRepository;
     }

    @Override
    @Transactional(value = "hwTransactionManager", readOnly = false, propagation = Propagation.REQUIRED)
    public User saveValidUser(User user) {
        //call repository
        int a = registrationRepository.saveValidUser(user);
        return null;
     }
}
