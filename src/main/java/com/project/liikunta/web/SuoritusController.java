package com.project.liikunta.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.liikunta.model.KategoriaRepository;
import com.project.liikunta.model.SuoritusRepository;

@Controller
public class SuoritusController {
	
	@Autowired
	private SuoritusRepository suorrepository;
	
	@Autowired
	private KategoriaRepository katrepository;
	
	//Näytetään lista suorituksista /suoritukset -endpointissa.
	@RequestMapping(value= {"/suoritukset"})
	public String suoritukset(Model model) {
		model.addAttribute("suoritukset", suorrepository.findAll());
		return "suoritukset";
	}

}
