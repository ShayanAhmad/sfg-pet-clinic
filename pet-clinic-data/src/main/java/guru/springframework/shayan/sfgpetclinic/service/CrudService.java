package guru.springframework.shayan.sfgpetclinic.service;

import java.util.Set;

/**
 * Created by Shayan Ahmad (sahmed) on 10-Nov-19.
 */
public interface CrudService<T, ID> {

    T findById(ID id);

    Set<T> findAll();

    void save(T t);

    void delete(T t);

    void deleteById(ID id);
}
