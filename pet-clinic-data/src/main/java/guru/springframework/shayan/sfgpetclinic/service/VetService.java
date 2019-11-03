package guru.springframework.shayan.sfgpetclinic.service;

import guru.springframework.shayan.sfgpetclinic.model.Vet;

import java.util.Set;

/**
 * Created by Shayan Ahmad (sahmed) on 03-Nov-19.
 */
public interface VetService {
    Vet findById(Long id);

    void save(Vet owner);

    Set<Vet> findAll();
}
