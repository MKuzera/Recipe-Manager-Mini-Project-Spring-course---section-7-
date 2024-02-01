package com.SpringCourse.Section7.Recipe;

import jakarta.validation.Valid;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
            Recipe recipe = new Recipe(0,"R","E",LocalDate.now(),"P");
            modelMap.put("recipe",recipe);

        return "add-recipe";
    }


    @RequestMapping(value = "/add-recipe",method = RequestMethod.POST)
    public String addRecipePage(@Valid Recipe recipe, BindingResult result){
        if(result.hasErrors()){
            return "add-recipe";
        }

        recipeService.addRecipe(recipe.getRecipeName() ,recipe.getDescription(),recipe.getAddedByUser(),recipe.getDateAdded());
        return "redirect:recipes";
    }

    @RequestMapping("/delete-recipe")
    public String deleteRecipe(@RequestParam int id){
        recipeService.removeRecipe(id);
        return "redirect:recipes";
    }

    @RequestMapping(value = "/update-recipe" , method = RequestMethod.GET)
    public String showUpdateRecipePage(@RequestParam int id,ModelMap modelMap){
        try {
            Recipe recipe = recipeService.getRecipeById(id);
            modelMap.addAttribute("recipe",recipe);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "add-recipe";
    }

    @RequestMapping(value = "/update-recipe",method = RequestMethod.POST)
    public String updateRecipe(@Valid Recipe recipe, BindingResult result){
        if(result.hasErrors()){
            return "add-recipe";
        }
        recipeService.updateRecipe(recipe);
        return "redirect:recipes";
    }
}
