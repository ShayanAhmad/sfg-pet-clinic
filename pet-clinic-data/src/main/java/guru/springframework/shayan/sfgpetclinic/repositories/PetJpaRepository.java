package guru.springframework.shayan.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.shayan.sfgpetclinic.model.Pet;

public interface PetJpaRepository extends CrudRepository<Pet, Long> {
}
