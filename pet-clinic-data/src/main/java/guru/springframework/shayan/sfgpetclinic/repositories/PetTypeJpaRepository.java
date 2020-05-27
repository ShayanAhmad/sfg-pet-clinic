package guru.springframework.shayan.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.shayan.sfgpetclinic.model.PetType;

public interface PetTypeJpaRepository extends CrudRepository<PetType, Long> {
}
