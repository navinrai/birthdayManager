package com.birthdaymanager.repository;

import com.birthdaymanager.common.Constants;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Created by umesh.soni on 3/17/2017.
 */
@Configuration
public class StandaloneInfrastructureConfig implements InfrastructureConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(StandaloneInfrastructureConfig.class);

    @Autowired
    private Environment environment;

     @Override
    @Bean(name ="appPath")
    public String appPath() {
        return getEnvProperty("app.path");
    }

    @Override
    @Bean
    public DataSource hwDataSource() {
        LOGGER.info("Initializing DataSource for Birthday celebration Application ");
        org.apache.tomcat.jdbc.pool.DataSource dataSource  = getDataSource(getEnvProperty("jdbc.driverClassName"),
                getEnvProperty("jdbc.url"),
                getEnvProperty("jdbc.username"),
                getEnvProperty("jdbc.password"),
                Constants.DATA_SOURCE_PARAMETER.MAX_ACTIVE, Constants.DATA_SOURCE_PARAMETER.INITIAL_SIZE, Constants.DATA_SOURCE_PARAMETER.REMOVE_ABANDONED_TIMEOUT);

        LOGGER.info("Initialized DataSource for Birthday celebration Application {}", getEnvProperty("jdbc.url"));
        return dataSource;
    }

    private String getEnvProperty(String key) {
        String property = environment.getRequiredProperty(key);
        if (property == null || property.trim().isEmpty() ) {
            LOGGER.error("property with key = " + key + " = " + property);
        }
        return property != null ? property.trim() : null;
    }

    private org.apache.tomcat.jdbc.pool.DataSource getDataSource(final String driverClassName,
                                                                 final String dbUrl,
                                                                 String dbUsername,
                                                                 String dbPassword,
                                                                 int maxActive,
                                                                 int initialSize,
                                                                 int removeAbandonedTimeout) {
        PoolProperties p = new PoolProperties();
        p.setDriverClassName(driverClassName);
        p.setUrl(dbUrl);
        p.setUsername(dbUsername);
        p.setPassword(dbPassword);
        p.setJmxEnabled(false);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(Constants.DATA_SOURCE_PARAMETER.VALIDATION_INTERVAL);
        p.setTimeBetweenEvictionRunsMillis(Constants.DATA_SOURCE_PARAMETER.TIME_BETWEEN_EVICTION_RUNS_MILLIS);
        p.setMaxActive(maxActive);
        p.setInitialSize(initialSize);
        p.setMaxWait(Constants.DATA_SOURCE_PARAMETER.MAX_WAIT);
        p.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        p.setMinEvictableIdleTimeMillis(Constants.DATA_SOURCE_PARAMETER.MIN_EVICTABLE_IDLE_TIME_MILLIS);
        p.setMinIdle(Constants.DATA_SOURCE_PARAMETER.MIN_IDLE);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer;" +
                        "org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer");

        org.apache.tomcat.jdbc.pool.DataSource dataSource1 = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource1.setPoolProperties(p);
        return dataSource1;
    }
}
