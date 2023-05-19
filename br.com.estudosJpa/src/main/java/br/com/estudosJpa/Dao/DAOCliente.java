package br.com.estudosJpa.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.estudosJpa.entidades.muitosParaUm.Cliente;
import br.com.estudosJpa.entidades.muitosParaUm.Produto;

public class DAOCliente {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoPU");
   
	
	public Cliente salvar(Cliente novoCliente) {
	    EntityManager em = emf.createEntityManager();

	    em.getTransaction().begin();
	    
	    // Verifica se a lista de produtos não é nula
	    if (novoCliente.getProdutos() != null) {
	        // Percorre a lista de produtos e persiste cada um deles
	        for (Produto produto : novoCliente.getProdutos()) {
	        	novoCliente.getProdutos().forEach(a -> a.setCliente(novoCliente));
	            em.persist(produto);
	        }
	    }
	    
	    // Persiste o objeto Cliente
	    em.persist(novoCliente);
	    em.getTransaction().commit();
	    em.close();
	    
	    return novoCliente;
	}

	
	public Cliente atualizar(Long id, Cliente novoCliente) {
		EntityManager em = emf.createEntityManager();
		Cliente  clienteAtual = em.find(Cliente.class, id);
		if(clienteAtual != null) {
			novoCliente.setId(id);
			novoCliente.getProdutos().forEach(a -> a.setCliente(novoCliente));
			em.getTransaction().begin();
			em.merge(novoCliente);
			em.getTransaction().commit();
			em.close();
			return novoCliente;
		}
		em.close();
		return null;
	}
	
	public void deletar(Long id) {
		EntityManager em = emf.createEntityManager();
		Cliente  clienteAtual = em.find(Cliente.class, id);
		if(clienteAtual != null) {
			em.getTransaction().begin();
			em.remove(clienteAtual);
			em.getTransaction().commit();
			em.close();
		}
		em.close();
	}
	
	public List<Cliente> listaClientes(){
		 EntityManager em = emf.createEntityManager();
		 TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Clientes c", Cliente.class);
		 List<Cliente> clientes = query.getResultList();
		 em.close();
		 return clientes;
	}
	
	public Cliente findById(Long id) {
		 EntityManager em = emf.createEntityManager();
		 Cliente cliente = em.find(Cliente.class, id);
		 if(cliente != null) {
			 return cliente;
		 }
		 return null;
	}
	
}
