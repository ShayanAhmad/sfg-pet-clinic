package guru.springframework.shayan.sfgpetclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.shayan.sfgpetclinic.model.Specialty;
import guru.springframework.shayan.sfgpetclinic.service.SpecialtyService;

/**
 * Every Vet will have the specialties.
 */
@Service
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty save(Specialty specialty) {
        return super.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        super.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
