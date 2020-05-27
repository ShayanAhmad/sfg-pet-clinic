package guru.springframework.shayan.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.shayan.sfgpetclinic.model.Specialty;

public interface SpecialtyJpaRepository extends CrudRepository<Specialty, Long> {
}
