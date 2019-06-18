package com.sky;

import com.reger.dubbo.rpc.filter.Utils;
import com.sky.common.exception.ApplicationException;
import com.sky.dynamicdb.multidb.EnableMultiDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableMultiDataSource
@MapperScan("com.sky.**.dao")
@EnableTransactionManagement
@EnableCaching
@EnableElasticsearchRepositories("com.sky.**.repository")
public class Application {

    public static void main(String[] args) {

        Utils.register(ApplicationException.class);
        SpringApplication.run(Application.class, args);
        synchronized (Application.class) {
            for (;;) {
                try {
                    Application.class.wait();
                }catch (Exception e) {

                }
            }
        }
    }
}
