package com.sky.dynamicdb.multidb;

import com.sky.dynamicdb.core.DynamicDataSourceHolder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAspect {

    @Value("${dynamic.datasource.names:slave}")
    private String dynamicDataSource;

    @Value("${dynamic.datasource.flag:slave}")
    private String dynamicDataSourceFlag;


    @Before("@annotation(targetDataSource)")
    public void before(TargetDataSource targetDataSource) {

        String dataSourceName = targetDataSource.value();
        if (dataSourceName.equals(dynamicDataSourceFlag)) {
            dataSourceName = DBLoadBalance.getDBWithRandom(dynamicDataSource);
            DynamicDataSourceHolder.putDataSource(dataSourceName);
        }
    }


    @After("@annotation(TargetDataSource)")
    public void after() {
        DynamicDataSourceHolder.removeDataSource();
    }
}
