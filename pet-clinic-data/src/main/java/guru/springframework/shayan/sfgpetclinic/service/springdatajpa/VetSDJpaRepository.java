package guru.springframework.shayan.sfgpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.shayan.sfgpetclinic.model.Vet;
import guru.springframework.shayan.sfgpetclinic.repositories.VetJpaRepository;
import guru.springframework.shayan.sfgpetclinic.service.VetService;

@Service
@Profile("spring-data-jpa")
public class VetSDJpaRepository implements VetService {

    private VetJpaRepository vetJpaRepository;

    public VetSDJpaRepository(VetJpaRepository vetJpaRepository) {
        this.vetJpaRepository = vetJpaRepository;
    }

    @Override
    public Vet findById(Long vetId) {
        return vetJpaRepository
                .findById(vetId)
                .orElse(null);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetJpaRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet save(Vet vet) {
        return vetJpaRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetJpaRepository.delete(vet);
    }

    @Override
    public void deleteById(Long vetId) {
        vetJpaRepository.deleteById(vetId);
    }
}
