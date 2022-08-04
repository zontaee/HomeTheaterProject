package com.oracle.HomeTheater;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@SpringBootApplication
public class HomeTheaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeTheaterApplication.class, args);
	}
	@Bean
	JPAQueryFactory jpaQueryFactory(EntityManager em){
		return new JPAQueryFactory(em);
	}

}
