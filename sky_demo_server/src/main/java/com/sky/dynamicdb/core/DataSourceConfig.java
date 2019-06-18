package com.sky.dynamicdb.core;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSourceConfig {

    @Autowired
    private DBProperties properties;
    @Value("${dynamic.default.db:master}")
    private String dynamicDefaultDB;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();

        if (null != properties.getMaster()) {
            targetDataSources.put(properties.getMaster().getPoolName(), properties.getMaster());
        } else {
            System.out.println("=======datasource master is null===========");
            System.exit(1);
        }

        List<HikariDataSource> hikaris = properties.getSlave();

        for(HikariDataSource item: hikaris) {
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
