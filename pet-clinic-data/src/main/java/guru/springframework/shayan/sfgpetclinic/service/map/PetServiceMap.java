package guru.springframework.shayan.sfgpetclinic.service.map;

import guru.springframework.shayan.sfgpetclinic.model.Pet;
import guru.springframework.shayan.sfgpetclinic.service.PetService;

import java.util.Set;

/**
 * Created by Shayan Ahmad (sahmed) on 10-Nov-19.
 */
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
