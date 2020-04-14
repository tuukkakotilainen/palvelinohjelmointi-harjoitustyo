package com.project.liikunta;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.liikunta.model.Suoritus;
import com.project.liikunta.model.SuoritusRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SuoritusRepositoryTest {
	
	@Autowired
	private SuoritusRepository suorrepository;
	
	@Test
	public void findByPaivamaaraShouldReturnSuoritus() {
		List<Suoritus> suoritukset = suorrepository.findByPaivamaara("1.4.2020");
		
		assertThat(suoritukset).hasSize(1);
		assertThat(suoritukset.get(0).getKesto()).isEqualTo("25 min");
	}

}
