package guru.springframework.shayan.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.shayan.sfgpetclinic.model.Visit;

public interface VisitJpaRepository extends CrudRepository<Visit, Long> {
}
