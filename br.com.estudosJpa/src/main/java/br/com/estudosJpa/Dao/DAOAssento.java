package br.com.estudosJpa.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.estudosJpa.entidades.muitosParaUm.Cliente;
import br.com.estudosJpa.entidades.umParaUm.Assento;

public class DAOAssento {
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoPU");
	
	
	public Assento salvar(Assento novoAssento) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(novoAssento);
		em.getTransaction().commit();
		em.close();
		return novoAssento;
	}
	
	public Assento atualizar(Long id, Assento novoAssento) {
		EntityManager em = emf.createEntityManager();
		Cliente  assentoAtual = em.find(Cliente.class, id);
		if(assentoAtual != null) {
			novoAssento.setId(id);
			em.getTransaction().begin();
			em.merge(novoAssento);
			em.getTransaction().commit();
			em.close();
			return novoAssento;
		}
		em.close();
		return null;
	}
	
	public void deletar(Long id) {
		EntityManager em = emf.createEntityManager();
		Assento  AssentoAtual = em.find(Assento.class, id);
		if(AssentoAtual != null) {
			em.getTransaction().begin();
			em.remove(AssentoAtual);
			em.getTransaction().commit();
			em.close();
		}
		em.close();
	}
	

	public List<Assento> listaAssentos(){
		 EntityManager em = emf.createEntityManager();
		 TypedQuery<Assento> query = em.createQuery("SELECT p FROM Assentos p", Assento.class);
		 List<Assento> Assentos = query.setMaxResults(10).getResultList();
		 em.close();
		 return Assentos;
	}
	
	public Assento findById(Long id) {
		 EntityManager em = emf.createEntityManager();
		 Assento assento = em.find(Assento.class, id);
		 if(assento!= null) {
			 return assento;
		 }
		 return null;
	}
	
}
