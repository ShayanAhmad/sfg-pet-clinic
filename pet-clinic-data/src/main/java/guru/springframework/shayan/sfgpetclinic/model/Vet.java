package guru.springframework.shayan.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shayan Ahmad (sahmed) on 27-Oct-19.
 */
public class Vet extends Person {

    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
