package guru.springframework.shayan.sfgpetclinic.service.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import guru.springframework.shayan.sfgpetclinic.model.BaseEntity;

/**
 * Created by Shayan Ahmad (sahmed) on 10-Nov-19.
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    T findById(ID id) {
        return map.get(id);
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T save(T object) {
        if (!Objects.isNull(object) && Objects.isNull(object.getId())) {
            object.setId(getNextId());
            map.put(object.getId(), object);

        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId() {
        return map.isEmpty() ? 1L : (Collections.max(map.keySet()) + 1);
    }

}
