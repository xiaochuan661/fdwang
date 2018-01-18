package com.mine.product.fdwang;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan({"com.mine.product.fdwang.mapper"})
@SpringBootApplication
@EnableTransactionManagement
public class FdWangProjectStarter {
    public static void main(String[] args){
        SpringApplication.run(FdWangProjectStarter.class,args);}
}
