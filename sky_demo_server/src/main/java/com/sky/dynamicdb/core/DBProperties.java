package com.sky.dynamicdb.core;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "dynamic.hikari")
public class DBProperties {

    private HikariDataSource master;
    private List<HikariDataSource> slave;

    public HikariDataSource getMaster() {
        return master;
    }

    public void setMaster(HikariDataSource master) {
        this.master = master;
    }

    public List<HikariDataSource> getSlave() {
        return slave;
    }

    public void setSlave(List<HikariDataSource> slave) {
        this.slave = slave;
    }
}
