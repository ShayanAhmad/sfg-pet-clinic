package guru.springframework.shayan.sfgpetclinic.model;

import java.io.Serializable;

/**
 * Created by Shayan Ahmad (sahmed) on 03-Nov-19.
 */
public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
