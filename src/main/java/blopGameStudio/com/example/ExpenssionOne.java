package blopGameStudio.com.example;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import blopGameStudio.com.example.services.BddService;

@SpringBootApplication
public class ExpenssionOne {

	public static void main(String[] args) {

		var app = new SpringApplication(ExpenssionOne.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
		var ctx =app.run(args);

		BddService bddService = ctx.getBean(BddService.class);
        bddService.insertBdd();
	}

}
