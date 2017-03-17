package com.birthdaymanager.repository;

import com.birthdaymanager.exceptions.SqlSessionFactoryCreatorException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

/**
 * Created by umesh.soni on 3/17/2017.
 */
public class SqlSessionFactoryCreator {
    /**
     * Logger to be used by class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SqlSessionFactoryCreator.class);

    private DataSource dataSource;
    private java.lang.String sqlMapLocation;


    /**
     * @param dataSource     Data source to be used
     * @param sqlMapLocation property name which defines the classpath location of the mapper config file
     */
    public SqlSessionFactoryCreator(final DataSource dataSource, final String sqlMapLocation) {

        if (dataSource == null) {
            throw new IllegalArgumentException("DataSource cannot be null");
        }
        if (sqlMapLocation == null) {
            throw new IllegalArgumentException("sqlMapLocation cannot be null");
        }

        this.dataSource = dataSource;
        this.sqlMapLocation = sqlMapLocation;
    }

    public SqlSessionFactory getObject() {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setConfigLocation(new ClassPathResource(sqlMapLocation));

        try {
            return sqlSessionFactory.getObject();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize sqlSessionFactory", e);
            throw new SqlSessionFactoryCreatorException("Failed to initialize sqlSessionFactory", e);
        }
    }
}
