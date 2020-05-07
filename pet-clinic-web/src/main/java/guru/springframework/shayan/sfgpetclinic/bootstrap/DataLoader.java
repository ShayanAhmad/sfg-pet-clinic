package guru.springframework.shayan.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.shayan.sfgpetclinic.model.Owner;
import guru.springframework.shayan.sfgpetclinic.model.Vet;
import guru.springframework.shayan.sfgpetclinic.service.OwnerService;
import guru.springframework.shayan.sfgpetclinic.service.VetService;

/**
 * To load data into our models.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;

    public DataLoader(VetService vetService, OwnerService ownerService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception {
        createAndSaveDummyOwner("Andrew", "Bee");
        createAndSaveDummyOwner("Bruce", "Lee");
        System.out.println("Owners loaded!");

        createAndSaveDummyVet("Dr. Aby", "Neil");
        createAndSaveDummyVet("Dr. Koki", "Na-Basu");
        System.out.println("Vets loaded!");
    }

    private void createAndSaveDummyOwner(String fName, String lName) {
        Owner owner = new Owner();
        owner.setFirstName(fName);
        owner.setLastName(lName);

        ownerService.save(owner);
    }

    private void createAndSaveDummyVet(String fName, String lName) {
        Vet vet = new Vet();
        vet.setFirstName(fName);
        vet.setLastName(lName);

        vetService.save(vet);
    }

}
