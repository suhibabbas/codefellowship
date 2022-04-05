package com.lab.CodeFellowship;

import com.lab.CodeFellowship.Models.Role;
import com.lab.CodeFellowship.Repositries.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CodeFellowshipApplication {

	private static final Logger log = LoggerFactory.getLogger(CodeFellowshipApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(CodeFellowshipApplication.class, args);


	}

	@Bean
	CommandLineRunner initDatabase(RoleRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Role("Admin")));
			log.info("Preloading " + repository.save(new Role("user")));
		};
	}
}
