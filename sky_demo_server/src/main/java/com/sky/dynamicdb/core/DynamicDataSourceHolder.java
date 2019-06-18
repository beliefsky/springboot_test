package com.sky.dynamicdb.core;

public class DynamicDataSourceHolder {

    private static String USEFUL_DB = null;

    private final static ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void putDataSource(String name) {
        THREAD_LOCAL.set(name);
    }

    public static String getDataSource() {
        if (null != USEFUL_DB) {
            return USEFUL_DB;
        }
        return THREAD_LOCAL.get();
    }

    public static void removeDataSource() {
        THREAD_LOCAL.remove();
    }
}
