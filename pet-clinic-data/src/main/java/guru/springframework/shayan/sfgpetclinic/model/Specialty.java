package guru.springframework.shayan.sfgpetclinic.model;

/**
 * Vet will have a specialty to handle the Pets.
 * This class denotes that specialty characteristics.
 */
public class Specialty extends BaseEntity {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
