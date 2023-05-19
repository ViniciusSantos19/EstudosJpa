package br.com.estudosJpa.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class GenericDAO<T> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoPU");
    private Class<T> entityClass;

   public GenericDAO (Class<T> classe){
	   this.entityClass = classe;
   }

    public T salvar(T entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    public T atualizar(Long id, T entity) {
    	 EntityManager em = emf.createEntityManager();
         T entityBd = em.find(entityClass, id);
         if (entityBd != null) {
             em.getTransaction().begin();
             em.merge(entity);
             em.getTransaction().commit();
         }
         em.close();
        return entity;
    }

    public void deletar(Long id) {
        EntityManager em = emf.createEntityManager();
        T entity = em.find(entityClass, id);
        if (entity != null) {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }
        em.close();
    }

    public List<T> listar() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<T> query = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass);
        List<T> lista = query.getResultList();
        em.close();
        return lista;
    }

    public T buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        T entity = em.find(entityClass, id);
        em.close();
        return entity;
    }
}
