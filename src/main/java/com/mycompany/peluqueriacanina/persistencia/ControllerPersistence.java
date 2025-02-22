package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Owner;
import com.mycompany.peluqueriacanina.logica.Pet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerPersistence {
    OwnerJpaController ownerJpa = new OwnerJpaController();
    PetJpaController petJpa = new PetJpaController();

    public void save(Owner owner, Pet pet) throws Exception {
        
        ownerJpa.create(owner);
        
        petJpa.create(pet);
        
    }

    public List<Pet> getAllPet() {
       return petJpa.findPetEntities();
    }

    public void deletePet(int id) throws Exception {
       petJpa.destroy(id);
    }

    public Pet findPetById(int num_client) {
        return petJpa.findPet(num_client);
    }

    public void updatedPet(Pet pet) {
        try {
            petJpa.edit(pet);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Owner findOwnerById(int id_owner) {
        return ownerJpa.findOwner(id_owner);
    }

    public void updatedOwner(Owner owner) {
        try {
            ownerJpa.edit(owner);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
