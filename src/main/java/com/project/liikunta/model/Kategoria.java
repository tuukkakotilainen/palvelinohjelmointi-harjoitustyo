package com.project.liikunta.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Kategoria {
	//Luodaan automaattisesti ainutlaatuinen pääavain.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kategoriaid;
	private String nimi;
	
	@JsonBackReference
	//Luodaan yhden syhde moneen -yhteys
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoria")
	private List<Suoritus> suoritukset;
	
	public Kategoria () {}
	
	public Kategoria(String nimi) {
		this.nimi = nimi;
	}

	//Autogeneroidaan getterit ja setterit
	public Long getKategoriaid() {
		return kategoriaid;
	}

	public void setKategoriaid(Long kategoriaid) {
		this.kategoriaid = kategoriaid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public List<Suoritus> getSuoritukset() {
		return suoritukset;
	}

	public void setSuoritukset(List<Suoritus> suoritukset) {
		this.suoritukset = suoritukset;
	}

	//Autogeneroidaan toString
	@Override
	public String toString() {
		return "Kategoria [kategoriaid=" + kategoriaid + ", nimi=" + nimi + ", suoritukset=" + suoritukset + "]";
	}
	

}
