package br.com.estudosJpa.entidades.umParaUm;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "Telespctadores")
public class Telespectador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Assento assento;

	public Telespectador(String nome, Assento assento) {
		this.nome = nome;
		this.assento = assento;
	}
	
	public Telespectador() {
		
	}
	
	public Assento getAssento() {
		return assento;
	}



	public void setAssento(Assento assento) {
		this.assento = assento;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
