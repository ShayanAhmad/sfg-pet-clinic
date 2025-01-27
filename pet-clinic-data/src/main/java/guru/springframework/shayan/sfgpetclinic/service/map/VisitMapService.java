package guru.springframework.shayan.sfgpetclinic.service.map;

import java.util.Objects;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.shayan.sfgpetclinic.model.Visit;
import guru.springframework.shayan.sfgpetclinic.service.VisitService;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit save(Visit visit) {

        if (Objects.isNull(visit.getPet()) || Objects.isNull(visit.getPet().getId())
                || Objects.isNull(visit.getPet().getOwner()) || Objects.isNull(visit.getPet().getOwner().getId())) {
            throw new RuntimeException("Invalid Visit!");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
