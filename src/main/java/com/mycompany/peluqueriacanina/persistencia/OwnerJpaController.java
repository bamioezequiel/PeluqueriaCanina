package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Owner;
import java.util.List;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class OwnerJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public OwnerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public OwnerJpaController() {
        emf = Persistence.createEntityManagerFactory("PeluqueriaCaninaPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Owner owner) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(owner);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
 // Edit Method
    public void edit(Owner owner) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            owner = em.merge(owner);
            em.getTransaction().commit();
        } catch (Exception ex) {
            int id = owner.getId_owner();
            if (findOwner(id) == null) {
                throw new Exception("The owner with id " + id + " no longer exists.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Destroy Method (Delete)
    public void destroy(int id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Owner owner;
            try {
                owner = em.getReference(Owner.class, id);
                owner.getId_owner();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("The owner with id " + id + " no longer exists.", enfe);
            }
            em.remove(owner);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Find Method (Retrieve by ID)
    public Owner findOwner(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Owner.class, id);
        } finally {
            em.close();
        }
    }

    // Find All Method (Retrieve all records)
    public List<Owner> findOwnerEntities() {
        return findOwnerEntities(true, -1, -1);
    }

    public List<Owner> findOwnerEntities(int maxResults, int firstResult) {
        return findOwnerEntities(false, maxResults, firstResult);
    }

    private List<Owner> findOwnerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Owner.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Count Method (Total count of records)
    public int getOwnerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Owner> rt = cq.from(Owner.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
