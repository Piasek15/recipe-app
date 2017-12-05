package pl.piasecki.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.piasecki.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
