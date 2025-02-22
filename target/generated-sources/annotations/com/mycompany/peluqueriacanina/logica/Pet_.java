package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.logica.Owner;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-20T23:03:50", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pet.class)
public class Pet_ { 

    public static volatile SingularAttribute<Pet, String> allergic;
    public static volatile SingularAttribute<Pet, Owner> owner;
    public static volatile SingularAttribute<Pet, String> color;
    public static volatile SingularAttribute<Pet, String> observations;
    public static volatile SingularAttribute<Pet, String> name;
    public static volatile SingularAttribute<Pet, Integer> num_client;
    public static volatile SingularAttribute<Pet, String> breed;
    public static volatile SingularAttribute<Pet, String> special_attention;

}