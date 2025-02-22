package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Pet;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PetJpaController implements Serializable {
  
    private EntityManagerFactory emf = null;

    public PetJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public PetJpaController() {
        emf = Persistence.createEntityManagerFactory("PeluqueriaCaninaPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pet pet) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pet);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

// Edit Method
    public void edit(Pet pet) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pet = em.merge(pet);
            em.getTransaction().commit();
        } catch (Exception ex) {
            int id = pet.getNum_client();
            if (findPet(id) == null) {
                throw new Exception("The pet with id " + id + " no longer exists.");
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
            Pet pet;
            try {
                pet = em.getReference(Pet.class, id);
                pet.getNum_client();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("The pet with id " + id + " no longer exists.", enfe);
            }
            em.remove(pet);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Find Method (Retrieve by ID)
    public Pet findPet(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pet.class, id);
        } finally {
            em.close();
        }
    }

    // Find All Method (Retrieve all records)
    public List<Pet> findPetEntities() {
        return findPetEntities(true, -1, -1);
    }

    public List<Pet> findPetEntities(int maxResults, int firstResult) {
        return findPetEntities(false, maxResults, firstResult);
    }

    private List<Pet> findPetEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pet.class));
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
    public int getPetCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pet> rt = cq.from(Pet.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}