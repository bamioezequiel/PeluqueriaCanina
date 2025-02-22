package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControllerPersistence;
import java.util.List;

public class Controller {
    ControllerPersistence controllerPersistence = new ControllerPersistence();
   
    public void save(String namePet, String breed, String color, String ownerName, String ownerPhone, String observations, String allergic, String specialAttention) throws Exception{
        Owner owner = new Owner();
        owner.setName(ownerName);
        owner.setPhone(ownerPhone);
        
        Pet pet = new Pet();
        pet.setName(namePet);
        pet.setBreed(breed);
        pet.setAllergic(allergic);
        pet.setColor(color);
        pet.setObservations(observations);
        pet.setSpecial_attention(specialAttention);
        pet.setOwner(owner);
        
        controllerPersistence.save(owner, pet);
    }

    public List<Pet> getPets() {
        return controllerPersistence.getAllPet();
    }

    public void deletePet(int id) throws Exception {
        controllerPersistence.deletePet(id);
    }

    public Pet findPetById(int num_client) {
       return controllerPersistence.findPetById(num_client);
    }

    public void updatedPet(Pet pet, String namePet, String breed, String color, String observations, String allergic, String specialAttention, String ownerName, String ownerPhone) {
        pet.setName(namePet);
        pet.setBreed(breed);
        pet.setColor(color);
        pet.setObservations(observations);
        pet.setAllergic(allergic);
        pet.setSpecial_attention(specialAttention);
        
        controllerPersistence.updatedPet(pet);
        
        Owner owner = this.findOwner(pet.getOwner().getId_owner());
        owner.setName(ownerName);
        owner.setPhone(ownerPhone);
        
        this.updatedOwner(owner);
    }

    private Owner findOwner(int id_owner) {
        return controllerPersistence.findOwnerById(id_owner);
    }

    private void updatedOwner(Owner owner) {
        controllerPersistence.updatedOwner(owner);
    }
}
