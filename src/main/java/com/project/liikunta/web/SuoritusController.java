package com.project.liikunta.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		model.addAttribute("kategoriat", katrepository.findAll());
		return "uusi";
	}
	
	//Endpointilla /save pystyy tallentamaan uuden tai muoktaun suorituksen.
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Suoritus suoritus) {
		suorrepository.save(suoritus);
		System.out.println(suoritus);
		return "redirect:suoritukset";
		
	}
	
	//Endpointilla /delete/{id} voi poistaa suorituksen, jos käyttäjällä on admin oikeudet.
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteSuoritus(@PathVariable("id") Long suoritusId, Model model) {
		suorrepository.deleteById(suoritusId);
		return "redirect:../suoritukset";
	}
	
	//Endpointilla /muokkaa/{id} voi muokata suoritusta.
	@RequestMapping(value = "/muokkaa/{id}", method = RequestMethod.GET)
	public String muokkaaSuoritusta(@PathVariable("id") Long suoritusId, Model model) {
		//Haetaan tietokannasta sql lauseella suoritus jolla on tämä id ja lisätään modeliin.
		model.addAttribute("suoritus", suorrepository.findById(suoritusId));
		model.addAttribute("kategoriat", katrepository.findAll());
		return "muokkaa";
	}
	
	//Endpointissa /login voi kirjautua sisään.
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	//Rest service suorituksille.
	@RequestMapping(value="/suoritus", method = RequestMethod.GET)
    public @ResponseBody List<Suoritus> suorituksetListRest() {	
        return (List<Suoritus>) suorrepository.findAll();
    }
	
	//Rest service, jolla voi hakea suorituksen id:n perusteella.
	@RequestMapping(value="/suoritus/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Suoritus> findSuoritusRest(@PathVariable("id") Long suoritusId) {	
    	return suorrepository.findById(suoritusId);
    }

}
