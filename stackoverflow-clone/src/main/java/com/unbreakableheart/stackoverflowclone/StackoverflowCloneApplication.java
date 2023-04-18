package com.unbreakableheart.stackoverflowclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StackoverflowCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackoverflowCloneApplication.class, args);
	}

}
