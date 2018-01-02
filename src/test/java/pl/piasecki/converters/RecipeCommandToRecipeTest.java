package pl.piasecki.converters;

import org.junit.Before;
import org.junit.Test;
import pl.piasecki.commands.CategoryCommand;
import pl.piasecki.commands.IngredientCommand;
import pl.piasecki.commands.NotesCommand;
import pl.piasecki.commands.RecipeCommand;
import pl.piasecki.domain.Difficulty;
import pl.piasecki.domain.Recipe;

import static org.junit.Assert.*;

public class RecipeCommandToRecipeTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    public static final Integer PREP_TIME = Integer.valueOf("5");
    public static final Integer COOK_TIME = Integer.valueOf("10");
    public static final Integer SERVINGS = Integer.valueOf("4");
    public static final String SOURCE = "Source";
    public static final String URL = "www.someurl.com";
    public static final String DIRECTIONS = "Directions";
    public static final Difficulty DIFFICULTY = Difficulty.EASY;
    public static final Long CAT_ID_1 = 1L;
    public static final Long CAT_ID_2 = 2L;
    public static final Long ING_ID_1 = 11L;
    public static final Long ING_ID_2 = 12L;
    public static final Long NOTES_ID = 30L;

    RecipeCommandToRecipe converter;

    @Before
    public void setUp() throws Exception {

        converter = new RecipeCommandToRecipe(new CategoryCommandToCategory(),
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new NotesCommandToNotes());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    public void convert() throws Exception {

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID_VALUE);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setDifficulty(DIFFICULTY);

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(NOTES_ID);
        recipeCommand.setNotes(notesCommand);

        CategoryCommand categoryCommand = new CategoryCommand();
        CategoryCommand categoryCommand2 = new CategoryCommand();
        categoryCommand.setId(CAT_ID_1);
        categoryCommand2.setId(CAT_ID_2);
        recipeCommand.getCategories().add(categoryCommand);
        recipeCommand.getCategories().add(categoryCommand2);

        IngredientCommand ingredientCommand = new IngredientCommand();
        IngredientCommand ingredientCommand2 = new IngredientCommand();
        ingredientCommand.setId(ING_ID_1);
        ingredientCommand2.setId(ING_ID_2);
        recipeCommand.getIngredients().add(ingredientCommand);
        recipeCommand.getIngredients().add(ingredientCommand2);

        Recipe recipe = converter.convert(recipeCommand);

        assertNotNull(recipe);
        assertEquals(ID_VALUE, recipe.getId());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(URL, recipe.getUrl());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(NOTES_ID, recipe.getNotes().getId());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(2, recipe.getIngredients().size());
    }

}