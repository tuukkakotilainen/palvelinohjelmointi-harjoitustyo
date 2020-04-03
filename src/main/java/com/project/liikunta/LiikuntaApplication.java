package com.project.liikunta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.liikunta.model.Kategoria;
import com.project.liikunta.model.KategoriaRepository;
import com.project.liikunta.model.Suoritus;
import com.project.liikunta.model.SuoritusRepository;

@SpringBootApplication
public class LiikuntaApplication {
	private static final Logger log = LoggerFactory.getLogger(LiikuntaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LiikuntaApplication.class, args);
	}
	
	//Tehdään muutama testi suoritus
	@Bean
	public CommandLineRunner suoritusDemo(SuoritusRepository suorrepository, KategoriaRepository katrepository) {
		return (args) -> {
			log.info("tallennetaan muutama kategoria ja suoritus");
			katrepository.save(new Kategoria("Juoksulenkki"));
			katrepository.save(new Kategoria("Kävelylenkki"));
			katrepository.save(new Kategoria("Kuntosali"));
			katrepository.save(new Kategoria("Pallopelit"));
			katrepository.save(new Kategoria("Uinti"));
			katrepository.save(new Kategoria("Pyöräily"));
			
			suorrepository.save(new Suoritus("1.4.2020", "25 min", "Purolan alueella 4 km.", katrepository.findBynimi("Juoksulenkki").get(0)));
			suorrepository.save(new Suoritus("3.4.2020", "1 h", "Perus treeni", katrepository.findBynimi("Kuntosali").get(0)));
			
			log.info("nouda kaikki suoritukset");
			for (Suoritus suoritus : suorrepository.findAll()) {
				log.info(suoritus.toString());
			}
		};
	}

}
