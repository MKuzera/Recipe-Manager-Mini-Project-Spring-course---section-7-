package com.SpringCourse.Section7.Recipe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
}
