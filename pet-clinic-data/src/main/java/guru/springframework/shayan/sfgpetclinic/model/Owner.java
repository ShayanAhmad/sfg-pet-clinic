package guru.springframework.shayan.sfgpetclinic.model;

import java.util.Set;

/**
 * Created by Shayan Ahmad (sahmed) on 27-Oct-19.
 */
public class Owner extends Person {

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
