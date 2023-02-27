package com.example.employee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.example.employee")
public class EmployeeApplication {

	//logging
	static final Logger logger  = LogManager.getLogger(EmployeeApplication.class.getName());

	public static void main(String[] args) {
		logger.info("entered application");
		SpringApplication.run(EmployeeApplication.class, args);

	}

}