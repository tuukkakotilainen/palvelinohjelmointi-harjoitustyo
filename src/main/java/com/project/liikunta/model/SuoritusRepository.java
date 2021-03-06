package com.project.liikunta.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface SuoritusRepository extends CrudRepository<Suoritus, Long> {
	
	List<Suoritus> findByPaivamaara(@Param("paivamaara")String paivamaara);

}
