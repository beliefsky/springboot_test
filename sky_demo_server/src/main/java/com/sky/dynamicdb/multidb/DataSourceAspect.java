package com.sky.dynamicdb.multidb;

import com.sky.dynamicdb.core.DBProperties;
import com.sky.dynamicdb.core.DynamicDataSourceHolder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAspect {

    @Autowired
    private DBProperties dbProperties;


    @Before("@annotation(targetDataSource)")
    public void before(TargetDataSource targetDataSource) {

        String dataSourceName = DBLoadBalance.getDBWithRandom(dbProperties.getSlave());
        DynamicDataSourceHolder.putDataSource(dataSourceName);
    }


    @After("@annotation(TargetDataSource)")
    public void after() {
        DynamicDataSourceHolder.removeDataSource();
    }
}
