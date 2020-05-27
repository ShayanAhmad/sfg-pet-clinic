package guru.springframework.shayan.sfgpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.shayan.sfgpetclinic.model.Visit;
import guru.springframework.shayan.sfgpetclinic.repositories.VisitJpaRepository;
import guru.springframework.shayan.sfgpetclinic.service.VisitService;

@Service
@Profile("spring-data-jpa")
public class VisitSDJpaRepository implements VisitService {

    private final VisitJpaRepository visitJpaRepository;

    public VisitSDJpaRepository(VisitJpaRepository visitJpaRepository) {
        this.visitJpaRepository = visitJpaRepository;
    }

    @Override
    public Visit findById(Long id) {
        return visitJpaRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitJpaRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit save(Visit visit) {
        return visitJpaRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitJpaRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitJpaRepository.deleteById(id);
    }
}
