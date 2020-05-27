package guru.springframework.shayan.sfgpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.shayan.sfgpetclinic.model.Specialty;
import guru.springframework.shayan.sfgpetclinic.repositories.SpecialtyJpaRepository;
import guru.springframework.shayan.sfgpetclinic.service.SpecialtyService;

@Service
@Profile("spring-data-jpa")
public class SpecialtySDJpaRepository implements SpecialtyService {

    private SpecialtyJpaRepository specialtyJpaRepository;

    public SpecialtySDJpaRepository(SpecialtyJpaRepository specialtyJpaRepository) {
        this.specialtyJpaRepository = specialtyJpaRepository;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyJpaRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyJpaRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyJpaRepository.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyJpaRepository.delete(specialty);
    }

    @Override
    public void deleteById(Long specialtyId) {
        specialtyJpaRepository.deleteById(specialtyId);
    }
}
