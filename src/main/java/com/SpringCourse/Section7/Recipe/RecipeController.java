package com.SpringCourse.Section7.Recipe;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipes")
    public String listAllRecipes(ModelMap modelMap){
        List<Recipe> listOfRecipes = recipeService.getListOfRecipes();
        modelMap.put("recipes",listOfRecipes);

        return "recipes";
    }
    @RequestMapping(value = "/add-recipe",method = RequestMethod.GET)
    public String showRecipePage(ModelMap modelMap){
            Recipe recipe = new Recipe(0,"x","d",LocalDate.now(),"f");
            modelMap.put("recipe",recipe);

        return "add-recipe";
    }


    @RequestMapping(value = "/add-recipe",method = RequestMethod.POST)
    public String addRecipePage(Recipe recipe){
        recipeService.addRecipe(recipe.getRecipeName() ,recipe.getDescription(),recipe.getAddedByUser());
        return "redirect:recipes";
    }
}
