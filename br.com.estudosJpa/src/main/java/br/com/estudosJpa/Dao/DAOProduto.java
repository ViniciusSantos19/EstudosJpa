package br.com.estudosJpa.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.estudosJpa.entidades.muitosParaUm.Cliente;
import br.com.estudosJpa.entidades.muitosParaUm.Produto;

public class DAOProduto {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoPU");
	
	
	public Produto salvar(Produto novoProduto) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(novoProduto);
		em.getTransaction().commit();
		em.close();
		return novoProduto;
	}
	
	public Produto atualizar(Long id, Produto novoProduto) {
		EntityManager em = emf.createEntityManager();
		Cliente  clienteAtual = em.find(Cliente.class, id);
		if(clienteAtual != null) {
			novoProduto.setId(id);
			em.getTransaction().begin();
			em.merge(novoProduto);
			em.getTransaction().commit();
			em.close();
			return novoProduto;
		}
		em.close();
		return null;
	}
	
	public void deletar(Long id) {
		EntityManager em = emf.createEntityManager();
		Produto  produtoAtual = em.find(Produto.class, id);
		if(produtoAtual != null) {
			em.getTransaction().begin();
			em.remove(produtoAtual);
			em.getTransaction().commit();
			em.close();
		}
		em.close();
	}
	

	public List<Produto> listaClientes(){
		 EntityManager em = emf.createEntityManager();
		 TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produtos p", Produto.class);
		 List<Produto> produtos = query.setMaxResults(10).getResultList();
		 em.close();
		 return produtos;
	}
	
	public Produto findById(Long id) {
		 EntityManager em = emf.createEntityManager();
		 Produto produto = em.find(Produto.class, id);
		 if(produto != null) {
			 return produto;
		 }
		 return null;
	}
	
}
