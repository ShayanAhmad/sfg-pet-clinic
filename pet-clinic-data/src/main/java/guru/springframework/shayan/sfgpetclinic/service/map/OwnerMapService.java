package guru.springframework.shayan.sfgpetclinic.service.map;

import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.shayan.sfgpetclinic.model.Owner;
import guru.springframework.shayan.sfgpetclinic.model.Pet;
import guru.springframework.shayan.sfgpetclinic.service.OwnerService;
import guru.springframework.shayan.sfgpetclinic.service.PetService;
import guru.springframework.shayan.sfgpetclinic.service.PetTypeService;

/**
 * Created by Shayan Ahmad (sahmed) on 10-Nov-19.
 */
@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private PetTypeService petTypeService;
    private PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

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
        if (Objects.isNull(owner.getPets())) {
            owner.getPets().forEach(pet -> {
                ensurePetTypeExistsAndIsProperlySet(pet);
                ensurePetExistsAndIsProperlySet(pet);
            });
        }
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

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    /**
     * Without PetType, Pet cannot exist.
     */
    private void ensurePetTypeExistsAndIsProperlySet(Pet pet) {
        if (Objects.isNull(pet.getPetType())) {
            throw new RuntimeException("PetType is required!");
        } else {
            if (Objects.isNull(pet.getPetType().getId())) {
                pet.setPetType(petTypeService.save(pet.getPetType()));
            }
        }
    }

    /**
     * Pet should be proper (having an ID) before saving for the Owner.
     */
    private void ensurePetExistsAndIsProperlySet(Pet pet) {
        if (Objects.isNull(pet.getId())) {
            Pet savedPet = petService.save(pet);
            pet.setId(savedPet.getId());
        }
    }
}
