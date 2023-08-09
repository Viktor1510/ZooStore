package com.example.zoostore.controllers;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.zoostore"})
@EntityScan(basePackages = {"com.example.zoostore.persistence.entities"})
@EnableJpaRepositories(basePackages = {"com.example.zoostore.persistence.repositories"})

public class ZooStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZooStoreApplication.class, args);
    }

}
