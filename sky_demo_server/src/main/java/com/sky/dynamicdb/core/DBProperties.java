package com.sky.dynamicdb.core;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "dynamic")
public class DBProperties {

    private Map<String, HikariDataSource> hikari;

    public Map<String, HikariDataSource> getHikari() {
        return hikari;
    }

    public void setHikari(Map<String, HikariDataSource> hikari) {
        this.hikari = hikari;
    }
}
