package guru.springframework.shayan.sfgpetclinic.service;

import guru.springframework.shayan.sfgpetclinic.model.Owner;

import java.util.Set;

/**
 * Created by Shayan Ahmad (sahmed) on 03-Nov-19.
 */
public interface OwnerService {
    Owner findById(Long id);

    void save(Owner owner);

    Set<Owner> findAll();
}
