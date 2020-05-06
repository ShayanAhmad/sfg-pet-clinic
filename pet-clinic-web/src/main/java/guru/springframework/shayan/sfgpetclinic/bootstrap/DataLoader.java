package guru.springframework.shayan.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.shayan.sfgpetclinic.model.Owner;
import guru.springframework.shayan.sfgpetclinic.model.Vet;
import guru.springframework.shayan.sfgpetclinic.service.OwnerService;
import guru.springframework.shayan.sfgpetclinic.service.VetService;
import guru.springframework.shayan.sfgpetclinic.service.map.OwnerServiceMap;
import guru.springframework.shayan.sfgpetclinic.service.map.VetServiceMap;

/**
 * To load data into our models.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetServiceMap;
    private final OwnerService ownerServiceMap;

    public DataLoader() {
        vetServiceMap = new VetServiceMap();
        ownerServiceMap = new OwnerServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        createAndSaveDummyOwner(1L, "Andrew", "Bee");
        createAndSaveDummyOwner(2L, "Bruce", "Lee");
        System.out.println("Owners loaded!");

        createAndSaveDummyVet(3L, "Dr. Aby", "Neil");
        createAndSaveDummyVet(4L, "Dr. Koki", "Na-Basu");
        System.out.println("Vets loaded!");
    }

    private void createAndSaveDummyOwner(Long id, String fName, String lName) {
        Owner owner = new Owner();
        owner.setId(id);
        owner.setFirstName(fName);
        owner.setLastName(lName);

        ownerServiceMap.save(owner);
    }

    private void createAndSaveDummyVet(Long id, String fName, String lName) {
        Vet vet = new Vet();
        vet.setId(id);
        vet.setFirstName(fName);
        vet.setLastName(lName);

        vetServiceMap.save(vet);
    }

}
