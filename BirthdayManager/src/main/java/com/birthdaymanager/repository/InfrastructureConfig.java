package com.birthdaymanager.repository;

import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * Created by umesh.soni on 3/17/2017.
 */
public interface InfrastructureConfig {String appPath();

    @Bean
    DataSource hwDataSource();
}
