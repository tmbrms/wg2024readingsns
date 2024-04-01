package com.ibmtambara.readingsns;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;

@SpringBootApplication
public class ReadingsnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingsnsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return arg -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();

			Arrays.sort(beanNames);
			for(String beanName: beanNames){
				System.out.println(beanName);

			}

		};
	}

}
