package com.project.liikunta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.liikunta.model.User;
import com.project.liikunta.model.Kategoria;
import com.project.liikunta.model.KategoriaRepository;
import com.project.liikunta.model.Suoritus;
import com.project.liikunta.model.SuoritusRepository;
import com.project.liikunta.model.UserRepository;

@SpringBootApplication
public class LiikuntaApplication {
	private static final Logger log = LoggerFactory.getLogger(LiikuntaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LiikuntaApplication.class, args);
	}
	
	//Tehdään muutama testi suoritus
	@Bean
	public CommandLineRunner suoritusDemo(SuoritusRepository suorrepository, KategoriaRepository katrepository, UserRepository urepository) {
		return (args) -> {
			log.info("tallennetaan muutama kategoria ja suoritus");
			katrepository.save(new Kategoria("Juoksulenkki"));
			katrepository.save(new Kategoria("Kävelylenkki"));
			katrepository.save(new Kategoria("Kuntosali"));
			katrepository.save(new Kategoria("Pallopelit"));
			katrepository.save(new Kategoria("Uinti"));
			katrepository.save(new Kategoria("Pyöräily"));
			
			suorrepository.save(new Suoritus("1.4.2020", "25 min", "Purolan alueella 4 km.", katrepository.findByNimi("Juoksulenkki").get(0)));
			suorrepository.save(new Suoritus("3.4.2020", "1 h", "Perus treeni", katrepository.findByNimi("Kuntosali").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("nouda kaikki suoritukset");
			for (Suoritus suoritus : suorrepository.findAll()) {
				log.info(suoritus.toString());
			}
		};
	}

}
