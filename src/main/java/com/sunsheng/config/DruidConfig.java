package com.sunsheng.config;

//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//@Configuration
//public class DruidConfig {
//    @Autowired
//    private ConnectionParamConfig jdbcParamConfig;
//    /**
//     * 重写 DataSource
//     * @return
//     */
//    @Bean
//    public DataSource dataSource() {
//        System.out.println("----------------------");
//        System.out.println(jdbcParamConfig.getUrl());
//        System.out.println(jdbcParamConfig.getDriverClassName());
//        System.out.println(jdbcParamConfig.getInitialSize());
//        System.out.println(jdbcParamConfig.getMinIdle());
//        System.out.println(jdbcParamConfig.getMaxActive());
//        System.out.println(jdbcParamConfig.getMaxWait());
//        System.out.println(jdbcParamConfig.getUsername());
//        System.out.println(jdbcParamConfig.getPassword());
//        System.out.println("----------------------");
//        DruidDataSource datasource = new DruidDataSource();
//        datasource.setUrl(jdbcParamConfig.getUrl());
//        datasource.setDriverClassName(jdbcParamConfig.getDriverClassName());
//        datasource.setInitialSize(jdbcParamConfig.getInitialSize());
//        datasource.setMinIdle(jdbcParamConfig.getMinIdle());
//        datasource.setMaxActive(jdbcParamConfig.getMaxActive());
//        datasource.setMaxWait(jdbcParamConfig.getMaxWait());
//        datasource.setUsername(jdbcParamConfig.getUsername());
//        datasource.setPassword(jdbcParamConfig.getPassword());
//        return datasource;
//    }
//
//}
