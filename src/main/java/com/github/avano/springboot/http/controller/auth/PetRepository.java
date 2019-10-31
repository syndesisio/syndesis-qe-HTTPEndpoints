package com.github.avano.springboot.http.controller.auth;

import com.github.avano.springboot.http.model.Pet;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public final class PetRepository {

    @Getter
    private static PetRepository instance = new PetRepository();

    private PetRepository(){
        pets = new HashMap<>();
    }

    @Getter
    private static Map<Long, Pet> pets;

    public static Pet getPet(long id){
        return pets.get(id);
    }

    public static void addPet(Pet pet){
        pets.put(pet.getId(), pet);
    }

}
