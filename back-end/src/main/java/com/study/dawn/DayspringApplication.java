package com.study.dawn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.study.dawn.dao")
public class DayspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DayspringApplication.class, args);
	}

}
