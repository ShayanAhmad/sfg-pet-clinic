package guru.springframework.shayan.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.shayan.sfgpetclinic.model.Owner;
import guru.springframework.shayan.sfgpetclinic.model.Pet;
import guru.springframework.shayan.sfgpetclinic.model.PetType;
import guru.springframework.shayan.sfgpetclinic.model.Specialty;
import guru.springframework.shayan.sfgpetclinic.model.Vet;
import guru.springframework.shayan.sfgpetclinic.service.OwnerService;
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

    public DataLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) loadDefaultData();
    }

    private void loadDefaultData() {
        PetType pt1 = createAndSaveDummyPetType("Cat");
        PetType pt2 = createAndSaveDummyPetType("Dog");
        System.out.println("Pets loaded!");

        createAndSaveDummyOwner("Andrew", "Bee", "Diatal ut.", "Debrecen", "+132456", "Bobby", pt1);
        createAndSaveDummyOwner("Bruce", "Lee", "Foshan", "Foshan city", "+321456", "Rosco", pt2);
        System.out.println("Owners loaded!");

        Specialty radiology = createSpecialty("Radiology");
        Specialty surgery = createSpecialty("Surgery");
        Specialty dentist = createSpecialty("Dentist");

        createAndSaveDummyVet("Dr. Aby", "Neil", radiology);
        createAndSaveDummyVet("Dr. Koki", "Na-Basu", surgery);
        System.out.println("Vets loaded!");
    }

    private PetType createAndSaveDummyPetType(String petName) {
        PetType petType = new PetType();
        petType.setName(petName);
        return petTypeService.save(petType);
    }

    private Specialty createSpecialty(String description) {
        Specialty specialty = new Specialty();
        specialty.setDescription(description);
        return specialty;
    }

    private void createAndSaveDummyOwner(String fName, String lName, String address, String city, String telephone, String petName, PetType petType) {
        Owner owner = new Owner();
        owner.setFirstName(fName);
        owner.setLastName(lName);
        owner.setAddress(address);
        owner.setCity(city);
        owner.setTelephone(telephone);

        Pet pet = new Pet();
        pet.setBirthDate(LocalDate.now());
        pet.setName(petName);
        pet.setPetType(petType);
        pet.setOwner(owner);

        owner.getPets().add(pet);

        ownerService.save(owner);
    }

    private void createAndSaveDummyVet(String fName, String lName, Specialty specialty) {
        Vet vet = new Vet();
        vet.setFirstName(fName);
        vet.setLastName(lName);
        vet.getSpecialties().add(specialty);

        vetService.save(vet);
    }

}
