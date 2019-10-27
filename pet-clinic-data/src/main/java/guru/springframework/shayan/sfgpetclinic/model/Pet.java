package guru.springframework.shayan.sfgpetclinic.model;

import java.time.LocalDate;

/**
 * Created by Shayan Ahmad (sahmed) on 27-Oct-19.
 */
public class Pet {

    private Owner owner;
    private LocalDate birthDate;
    private PetType petType;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }
}
