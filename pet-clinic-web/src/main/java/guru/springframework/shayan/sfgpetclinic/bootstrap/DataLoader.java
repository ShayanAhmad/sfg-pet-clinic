package guru.springframework.shayan.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.shayan.sfgpetclinic.model.Owner;
import guru.springframework.shayan.sfgpetclinic.model.Pet;
import guru.springframework.shayan.sfgpetclinic.model.PetType;
import guru.springframework.shayan.sfgpetclinic.model.Vet;
import guru.springframework.shayan.sfgpetclinic.service.OwnerService;
import guru.springframework.shayan.sfgpetclinic.service.PetService;
import guru.springframework.shayan.sfgpetclinic.service.PetTypeService;
import guru.springframework.shayan.sfgpetclinic.service.VetService;

/**
 * To load data into our models.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService, PetService petService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadDefaultData();
    }

    private void loadDefaultData() {
        PetType pt1 = createAndSaveDummyPetType("Cat");
        PetType pt2 = createAndSaveDummyPetType("Dog");
        System.out.println("Loaded Pet types!");

        Owner o1 = createAndSaveDummyOwner("Andrew", "Bee", "Diatal ut.", "Debrecen", "+132456");
        Owner o2 = createAndSaveDummyOwner("Bruce", "Lee", "Foshan", "Foshan city", "+321456");
        System.out.println("Owners loaded!");

        createAndSaveDummyPet(o1, pt1, "Bobby");
        createAndSaveDummyPet(o2, pt2, "Rocco");
        System.out.println("Pets loaded!");

        createAndSaveDummyVet("Dr. Aby", "Neil");
        createAndSaveDummyVet("Dr. Koki", "Na-Basu");
        System.out.println("Vets loaded!");
    }

    private void createAndSaveDummyPet(Owner o1, PetType pt1, String petName) {
        Pet pet = new Pet();
        pet.setBirthDate(LocalDate.now());
        pet.setName(petName);
        pet.setPetType(pt1);
        pet.setOwner(o1);

        petService.save(pet);
    }

    private PetType createAndSaveDummyPetType(String petName) {
        PetType petType = new PetType();
        petType.setName(petName);
        return petTypeService.save(petType);
    }

    private Owner createAndSaveDummyOwner(String fName, String lName, String address, String city, String telephone) {
        Owner owner = new Owner();
        owner.setFirstName(fName);
        owner.setLastName(lName);
        owner.setAddress(address);
        owner.setCity(city);
        owner.setTelephone(telephone);

        return ownerService.save(owner);
    }

    private void createAndSaveDummyVet(String fName, String lName) {
        Vet vet = new Vet();
        vet.setFirstName(fName);
        vet.setLastName(lName);

        vetService.save(vet);
    }

}
