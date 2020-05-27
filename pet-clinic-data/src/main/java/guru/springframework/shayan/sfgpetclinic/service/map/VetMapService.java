package guru.springframework.shayan.sfgpetclinic.service.map;

import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.shayan.sfgpetclinic.model.Specialty;
import guru.springframework.shayan.sfgpetclinic.model.Vet;
import guru.springframework.shayan.sfgpetclinic.service.SpecialtyService;
import guru.springframework.shayan.sfgpetclinic.service.VetService;

/**
 * Created by Shayan Ahmad (sahmed) on 10-Nov-19.
 */
@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet save(Vet vet) {
        if (!vet.getSpecialties().isEmpty()) {
            vet.getSpecialties().forEach(specialty -> {
                if (Objects.isNull(specialty.getId())) {
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
