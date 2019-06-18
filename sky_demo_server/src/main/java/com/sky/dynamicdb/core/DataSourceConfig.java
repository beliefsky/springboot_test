package com.sky.dynamicdb.core;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DataSourceConfig<T> {

    @Autowired
    private DBProperties properties;
    @Value("${dynamic.default.db:master}")
    private String dynamicDefaultDB;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        Map<String, HikariDataSource> hikaris = properties.getHikari();

        HikariDataSource hikariDataSource, masterDataSource = null;
        for (Map.Entry<String, HikariDataSource> entry : hikaris.entrySet()) {
            hikariDataSource = entry.getValue();
            targetDataSources.put(hikariDataSource.getPoolName(), hikariDataSource);
            if (hikariDataSource.getPoolName().equals(dynamicDefaultDB)) {
                masterDataSource = hikariDataSource;
            }
        }

        DynamicDataSouce dataSouce = new DynamicDataSouce();
        dataSouce.setTargetDataSources(targetDataSources);
        if (null != masterDataSource) {
            dataSouce.setDefaultTargetDataSource(masterDataSource);
        }
        return dataSouce;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
