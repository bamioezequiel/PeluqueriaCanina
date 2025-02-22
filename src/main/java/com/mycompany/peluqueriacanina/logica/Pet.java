package com.mycompany.peluqueriacanina.logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int num_client;
    private String name;
    private String breed;
    private String color;
    private String allergic;
    private String special_attention;
    private String observations;
    
    @OneToOne
    private Owner owner;
    
    public Pet() {
        
    }

    public Pet(int num_client, String name, String breed, String color, String allergic, String special_attention, String observations, Owner owner) {
        this.num_client = num_client;
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.allergic = allergic;
        this.special_attention = special_attention;
        this.observations = observations;
        this.owner = owner;
    }

    public String getAllergic() {
        return allergic;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getNum_client() {
        return num_client;
    }

    public String getObservations() {
        return observations;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getSpecial_attention() {
        return special_attention;
    }

    public void setAllergic(String allergic) {
        this.allergic = allergic;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNum_client(int num_client) {
        this.num_client = num_client;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setSpecial_attention(String special_attention) {
        this.special_attention = special_attention;
    }
    
    
    
    
    
    
}
