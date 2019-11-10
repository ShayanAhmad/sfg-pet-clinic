package guru.springframework.shayan.sfgpetclinic.service.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shayan Ahmad (sahmed) on 10-Nov-19.
 */
public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    T findById(ID id) {
        return map.get(id);
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T save(ID id, T t) {
        return map.put(id, t);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(ID id) {
        map.remove(id);
    }

}
