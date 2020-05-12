package guru.springframework.shayan.sfgpetclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.shayan.sfgpetclinic.model.PetType;
import guru.springframework.shayan.sfgpetclinic.service.PetTypeService;

/**
 * Service Map implementation of PetType.
 */
@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType save(PetType t) {
        return super.save(t);
    }

    @Override
    public void delete(PetType t) {
        super.delete(t);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
