package guru.springframework.shayan.sfgpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.shayan.sfgpetclinic.model.PetType;
import guru.springframework.shayan.sfgpetclinic.repositories.PetTypeJpaRepository;
import guru.springframework.shayan.sfgpetclinic.service.PetTypeService;

@Service
@Profile("spring-data-jpa")
public class PetTypeSDJpaRepository implements PetTypeService {

    private PetTypeJpaRepository petTypeJpaRepository;

    public PetTypeSDJpaRepository(PetTypeJpaRepository petTypeJpaRepository) {
        this.petTypeJpaRepository = petTypeJpaRepository;
    }

    @Override
    public PetType findById(Long petTypeId) {
        return petTypeJpaRepository
                .findById(petTypeId)
                .orElse(null);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypeSet = new HashSet<>();
        petTypeJpaRepository.findAll().forEach(petTypeSet::add);
        return petTypeSet;
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeJpaRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeJpaRepository.delete(petType);
    }

    @Override
    public void deleteById(Long petTypeId) {
        petTypeJpaRepository.deleteById(petTypeId);
    }
}
