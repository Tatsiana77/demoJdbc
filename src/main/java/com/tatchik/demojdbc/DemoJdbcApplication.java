package com.tatchik.demojdbc;

import com.tatchik.demojdbc.dao.AuthorDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DemoJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJdbcApplication.class, args);


    }

}
