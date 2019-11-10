package guru.springframework.shayan.sfgpetclinic.service.map;

import guru.springframework.shayan.sfgpetclinic.model.Vet;
import guru.springframework.shayan.sfgpetclinic.service.VetService;

import java.util.Set;

/**
 * Created by Shayan Ahmad (sahmed) on 10-Nov-19.
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
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
        return super.save(vet.getId(), vet);
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
