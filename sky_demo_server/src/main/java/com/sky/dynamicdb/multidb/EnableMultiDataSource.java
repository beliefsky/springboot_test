package com.sky.dynamicdb.multidb;

import com.sky.dynamicdb.core.DBProperties;
import com.sky.dynamicdb.core.DataSourceConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({DataSourceAspect.class, DataSourceConfig.class, DBProperties.class})
public @interface EnableMultiDataSource {
}
