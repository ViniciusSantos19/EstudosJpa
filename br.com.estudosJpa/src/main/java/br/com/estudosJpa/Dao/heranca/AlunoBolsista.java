package br.com.estudosJpa.Dao.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AB")
public class AlunoBolsista extends Aluno{
	
	private double valorBolsa;

	public AlunoBolsista() {

	}

	public AlunoBolsista(String nome, double valorBolsa) {
		super(nome);
		this.valorBolsa = valorBolsa;
	}

	public double getValorBolsa() {
		return valorBolsa;
	}

	public void setValorBolsa(double valorBolsa) {
		this.valorBolsa = valorBolsa;
	}
	
}
