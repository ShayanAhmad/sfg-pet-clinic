package guru.springframework.shayan.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.shayan.sfgpetclinic.model.Vet;

public interface VetJpaRepository extends CrudRepository<Vet, Long> {
}
