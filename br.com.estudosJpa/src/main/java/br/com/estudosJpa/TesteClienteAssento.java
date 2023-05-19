package br.com.estudosJpa;

import br.com.estudosJpa.Dao.DAOAssento;
import br.com.estudosJpa.Dao.DAOTelespectador;
import br.com.estudosJpa.entidades.umParaUm.Assento;
import br.com.estudosJpa.entidades.umParaUm.Telespectador;

public class TesteClienteAssento {

	public static void main(String[] args) {
		DAOAssento daoAssento = new DAOAssento();
		DAOTelespectador daoTelespectador = new DAOTelespectador();
		Assento assento = new Assento("A3");
		Telespectador telespectador = new Telespectador("Maria", assento);
		//daoAssento.salvar(assento);
		daoTelespectador.salvar(telespectador);
		
		Telespectador tel = daoTelespectador.findById(2l);
		System.out.println(tel.getNome());
		System.out.println(tel.getAssento().getLocalizacao());

	}

}
