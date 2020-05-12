package guru.springframework.shayan.sfgpetclinic.service.map;

import java.util.Set;

import org.springframework.stereotype.Component;

import guru.springframework.shayan.sfgpetclinic.model.Owner;
import guru.springframework.shayan.sfgpetclinic.service.OwnerService;

/**
 * Created by Shayan Ahmad (sahmed) on 10-Nov-19.
 */
@Component
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
