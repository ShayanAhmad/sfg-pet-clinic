package guru.springframework.shayan.sfgpetclinic.service;

import guru.springframework.shayan.sfgpetclinic.model.Pet;

import java.util.Set;

/**
 * Created by Shayan Ahmad (sahmed) on 03-Nov-19.
 */
public interface PetService {
    Pet findById(Long id);

    void save(Pet owner);

    Set<Pet> findAll();
}
