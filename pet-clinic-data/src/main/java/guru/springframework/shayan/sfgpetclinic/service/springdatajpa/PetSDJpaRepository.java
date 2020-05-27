package guru.springframework.shayan.sfgpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.shayan.sfgpetclinic.model.Pet;
import guru.springframework.shayan.sfgpetclinic.repositories.PetJpaRepository;
import guru.springframework.shayan.sfgpetclinic.service.PetService;

@Service
@Profile("spring-data-jpa")
public class PetSDJpaRepository implements PetService {

    private PetJpaRepository petJpaRepository;

    public PetSDJpaRepository(PetJpaRepository petJpaRepository) {
        this.petJpaRepository = petJpaRepository;
    }

    @Override
    public Pet findById(Long aLong) {
        return petJpaRepository
                .findById(aLong)
                .orElse(null);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petJpaRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet save(Pet pet) {
        return petJpaRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petJpaRepository.delete(pet);
    }

    @Override
    public void deleteById(Long petId) {
        petJpaRepository.deleteById(petId);
    }
}
