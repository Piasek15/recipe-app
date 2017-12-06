package pl.piasecki.services;

import pl.piasecki.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

}
