package br.com.estudosJpa.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.estudosJpa.entidades.muitosParaUm.Cliente;
import br.com.estudosJpa.entidades.umParaUm.Telespectador;

public class DAOTelespectador {
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoPU");
	
	
	public Telespectador salvar(Telespectador novoTelespectador) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(novoTelespectador);
		em.getTransaction().commit();
		em.close();
		return novoTelespectador;
	}
	
	public Telespectador atualizar(Long id, Telespectador novoTelespectador) {
		EntityManager em = emf.createEntityManager();
		Cliente  telespectadorAtual = em.find(Cliente.class, id);
		if(telespectadorAtual != null) {
			novoTelespectador.setId(id);
			em.getTransaction().begin();
			em.merge(novoTelespectador);
			em.getTransaction().commit();
			em.close();
			return novoTelespectador;
		}
		em.close();
		return null;
	}
	
	public void deletar(Long id) {
		EntityManager em = emf.createEntityManager();
		Telespectador  telespectadorAtual = em.find(Telespectador.class, id);
		if(telespectadorAtual != null) {
			em.getTransaction().begin();
			em.remove(telespectadorAtual);
			em.getTransaction().commit();
			em.close();
		}
		em.close();
	}
	

	public List<Telespectador> listaTelespectadors(){
		 EntityManager em = emf.createEntityManager();
		 TypedQuery<Telespectador> query = em.createQuery("SELECT p FROM Telespectadors p", Telespectador.class);
		 List<Telespectador> telespectadores = query.setMaxResults(10).getResultList();
		 em.close();
		 return telespectadores;
	}
	
	public Telespectador findById(Long id) {
		 EntityManager em = emf.createEntityManager();
		 Telespectador telespectador = em.find(Telespectador.class, id);
		 if(telespectador!= null) {
			 return telespectador;
		 }
		 return null;
	}
	
}
