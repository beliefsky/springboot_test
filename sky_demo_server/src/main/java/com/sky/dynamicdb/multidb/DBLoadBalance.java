package com.sky.dynamicdb.multidb;

import java.util.Random;

public class DBLoadBalance {

    public static String getDBWithRandom(String dbs) {
        String[] dynamicDBs = dbs.split(",");
        int num = new Random().nextInt(dynamicDBs.length);
        return dynamicDBs[num];
    }
}
