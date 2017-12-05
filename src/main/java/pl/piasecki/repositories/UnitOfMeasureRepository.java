package pl.piasecki.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.piasecki.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
