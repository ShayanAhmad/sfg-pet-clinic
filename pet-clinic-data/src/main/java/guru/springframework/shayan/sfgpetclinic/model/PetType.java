package guru.springframework.shayan.sfgpetclinic.model;

/**
 * Created by Shayan Ahmad (sahmed) on 27-Oct-19.
 */
public class PetType extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
