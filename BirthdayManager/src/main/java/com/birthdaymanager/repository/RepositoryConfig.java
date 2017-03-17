package com.birthdaymanager.repository;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by umesh.soni on 3/17/2017.
 */
@Configuration
@ComponentScan(basePackages = { "com.birthdaymanager" })
@Import(value = {StandaloneInfrastructureConfig.class})
public class RepositoryConfig {

    @Autowired
    private InfrastructureConfig infrastructureConfig;

    @Bean(name = "hwSessionFactory")
    public SqlSessionFactory hwSqlSessionFactory() {
        return new SqlSessionFactoryCreator(infrastructureConfig.hwDataSource(),"hw-sql-config.xml")
                .getObject();
    }

    @Bean( name = "hwTransactionManager" )
    public PlatformTransactionManager psTransactionManager() {
        return new DataSourceTransactionManager( infrastructureConfig.hwDataSource() );
    }
}