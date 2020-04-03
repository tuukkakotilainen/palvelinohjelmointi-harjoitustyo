package com.project.liikunta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Suoritus {
	//Luodaan automaattisesti ainutlaatuinen pääavain.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String paivamaara;
	private String kesto;
	private String kuvaus;

	//Luodaan monen suhde yhteen -yhteys
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "kategoriaid")
	private Kategoria kategoria;
	
		public Suoritus() {}
		
		public Suoritus(String paivamaara, String kesto, String kuvaus, Kategoria kategoria) {
			super();
			this.paivamaara = paivamaara;
			this.kesto = kesto;
			this.kuvaus = kuvaus;
			this.kategoria = kategoria;
		}
		
		//Autogeneroidaan Getterit ja setterit kaikille muille paitsi id:lle.
		//id:lle tehdään vain getteri.
		public Long getId() {
			return id;
		}

		public String getPaivamaara() {
			return paivamaara;
		}

		public void setPaivamaara(String paivamaara) {
			this.paivamaara = paivamaara;
		}

		public String getKesto() {
			return kesto;
		}

		public void setKesto(String kesto) {
			this.kesto = kesto;
		}

		public String getKuvaus() {
			return kuvaus;
		}

		public void setKuvaus(String kuvaus) {
			this.kuvaus = kuvaus;
		}

		public Kategoria getKategoria() {
			return kategoria;
		}

		public void setKategoria(Kategoria kategoria) {
			this.kategoria = kategoria;
		}
		
		//Autogeneroidaan ToString
		@Override
		public String toString() {
			return "Suoritus [id=" + id + ", paivamaara=" + paivamaara + ", kesto=" + kesto + ", kuvaus=" + kuvaus
					+ "]";
		}
		
		
	
}
