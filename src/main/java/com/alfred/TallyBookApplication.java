package com.alfred;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan(basePackages = {"com.alfred.sys.mapper"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TallyBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(TallyBookApplication.class, args);
    }

}
