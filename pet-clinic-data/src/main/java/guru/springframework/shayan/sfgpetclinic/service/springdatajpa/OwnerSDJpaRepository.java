package guru.springframework.shayan.sfgpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.shayan.sfgpetclinic.model.Owner;
import guru.springframework.shayan.sfgpetclinic.repositories.OwnerJpaRepository;
import guru.springframework.shayan.sfgpetclinic.service.OwnerService;

@Service
@Profile("spring-data-jpa")
public class OwnerSDJpaRepository implements OwnerService {

    private final OwnerJpaRepository ownerJpaRepository;

    public OwnerSDJpaRepository(OwnerJpaRepository ownerJpaRepository) {
        this.ownerJpaRepository = ownerJpaRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerJpaRepository.findByLastName(lastName);
    }

    @Override
    public Owner findById(Long ownerId) {
        return ownerJpaRepository
                .findById(ownerId)
                .orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerJpaRepository.findAll().forEach(ownerSet::add);
        return ownerSet;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerJpaRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerJpaRepository.delete(owner);
    }

    @Override
    public void deleteById(Long ownerId) {
        ownerJpaRepository.deleteById(ownerId);
    }
}
