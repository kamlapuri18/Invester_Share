package com.Invester_Share;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class InvesterShareApplication {


	public static void main(String[] args) {
		SpringApplication.run(InvesterShareApplication.class, args);
	}

}
