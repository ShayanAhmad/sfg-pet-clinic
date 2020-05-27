package guru.springframework.shayan.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.shayan.sfgpetclinic.model.Owner;

public interface OwnerJpaRepository extends CrudRepository<Owner, Long> {
}
