package com.birthdaymanager.repository;


import com.birthdaymanager.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by umesh.soni on 3/16/2017.
 */
@Mapper
@Transactional(value = "hwTransactionManager", readOnly = true )
public interface RegistrationRepository {

    @Transactional(value = "hwTransactionManager", readOnly = false, propagation = Propagation.REQUIRED)
    int saveValidUser(User user);
}
