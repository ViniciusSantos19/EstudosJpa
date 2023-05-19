package br.com.estudosJpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.estudosJpa.Dao.DAOCliente;
import br.com.estudosJpa.Dao.DAOProduto;
import br.com.estudosJpa.entidades.muitosParaUm.Cliente;
import br.com.estudosJpa.entidades.muitosParaUm.Produto;

public class Princiapal {
	public static void main(String[] args) {
	  DAOCliente dao = new DAOCliente();
	  DAOProduto daoProduto = new DAOProduto();
	 List<Produto> compras = new ArrayList<Produto>();
	  Cliente clie = new Cliente("Sanji Vin Smoke","cozinha@gmail", compras);
	  dao.atualizar(6l, clie);
	  
	  List<Cliente> lista = dao.listaClientes();
	  lista.forEach(a -> {
		    System.out.println("\t");
		  	System.out.println("ID: " + a.getId() + ", Nome: " + a.getNome() + ", E-mail: " + a.getEmail());
		    System.out.println("Produtos:");
		    a.getProdutos().forEach(p -> System.out.println("  Nome: " + p.getNome() + ", Preço: " + p.getPreco()));
		});

	  
	}

}
