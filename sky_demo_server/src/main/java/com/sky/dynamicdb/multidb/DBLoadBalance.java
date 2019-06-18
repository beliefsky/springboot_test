package com.sky.dynamicdb.multidb;

import com.zaxxer.hikari.HikariDataSource;

import java.util.List;
import java.util.Random;

class DBLoadBalance {

    static String getDBWithRandom(List<HikariDataSource> slaves) {
        HikariDataSource tmp = slaves.get(new Random().nextInt(slaves.size()));
        return tmp.getPoolName();
    }
}
