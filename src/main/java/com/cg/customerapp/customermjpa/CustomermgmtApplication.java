package com.cg.customerapp.customermjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class CustomermgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomermgmtApplication.class, args);
	}

}
