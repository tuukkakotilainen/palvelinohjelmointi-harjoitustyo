package com.project.liikunta.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.liikunta.model.KategoriaRepository;
import com.project.liikunta.model.Suoritus;
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
	
	//Endpointista /uusi voi luoda uuden suorituksen.
	@RequestMapping(value = "/uusi")
	public String uusiSuoritus(Model model) {
		model.addAttribute("suoritus", new Suoritus());
		model.addAttribute("categories", katrepository.findAll());
		return "uusi";
	}
	
	//Endpointilla /save pystyy tallentamaan uuden tai muoktaun suorituksen.
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Suoritus suoritus) {
		suorrepository.save(suoritus);
		return "redirect:suoritukset";
	}

}
