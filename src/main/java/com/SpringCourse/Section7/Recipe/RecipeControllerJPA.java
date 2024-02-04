package com.SpringCourse.Section7.Recipe;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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
public class RecipeControllerJPA {



    private RecipeService recipeService;
    private RecipeRepository recipeRepository;

    public RecipeControllerJPA(RecipeRepository recipeRepository) {

        this.recipeRepository = recipeRepository;
    }

    @RequestMapping("/recipes")
    public String listAllRecipesBasedOnUsername(ModelMap modelMap){
        List<Recipe> listOfRecipes = recipeRepository.findByAddedByUser(SecurityContextHolder.getContext().getAuthentication().getName());
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
    public String addRecipePage(@Valid Recipe recipe, BindingResult result,ModelMap model){
        if(result.hasErrors()){
            return "add-recipe";
        }
        String username = getLoggedInUsername(model);
        recipe.setAddedByUser(username);
        recipeRepository.save(recipe);
        return "redirect:recipes";
    }

    @RequestMapping("/delete-recipe")
    public String deleteRecipe(@RequestParam int id){
        recipeRepository.deleteById(id);
        return "redirect:recipes";
    }

    @RequestMapping(value = "/update-recipe" , method = RequestMethod.GET)
    public String showUpdateRecipePage(@RequestParam int id,ModelMap modelMap){
        try {
            Recipe recipe = recipeRepository.getReferenceById(id);
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
        recipeRepository.save(recipe);
        return "redirect:recipes";
    }
    private String getLoggedInUsername(ModelMap model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
