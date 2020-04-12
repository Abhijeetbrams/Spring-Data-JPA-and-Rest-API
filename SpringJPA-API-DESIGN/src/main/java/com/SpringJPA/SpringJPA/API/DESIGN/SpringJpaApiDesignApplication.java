package com.SpringJPA.SpringJPA.API.DESIGN;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.Controller","com.Entity","com.Service","com.Repository","com.GlobalException","com.Security"})
@EntityScan("com.Entity")
@EnableJpaRepositories("com.Repository")
public class SpringJpaApiDesignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApiDesignApplication.class, args);
	}

}
