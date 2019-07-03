package com.sky.dynamicdb.core;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DataSourceConfig {

    @Autowired
    private DBProperties properties;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();

        if (null != properties.getMaster()) {
            targetDataSources.put(properties.getMaster().getPoolName(), properties.getMaster());
        } else {
            System.out.println("=======datasource master is null===========");
            System.exit(1);
        }


        for (HikariDataSource item : properties.getSlave()) {
            targetDataSources.put(item.getPoolName(), item);
        }
        DynamicDataSource dataSouce = new DynamicDataSource();
        dataSouce.setTargetDataSources(targetDataSources);
        dataSouce.setDefaultTargetDataSource(properties.getMaster());


        return dataSouce;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
