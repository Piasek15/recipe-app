package pl.piasecki.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.piasecki.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{
}
