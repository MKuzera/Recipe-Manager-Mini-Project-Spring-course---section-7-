package com.SpringCourse.Section7.Recipe;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class RecipeService {
    public static int count = 3;
    private static List<Recipe> listOfRecipes = new ArrayList<>();
    static{
        listOfRecipes.add(new Recipe(1,
                "Kurczak Curry",
                "Kurcza w sosie curry z ryzem",
                LocalDate.now(),
                "me")

                );
        listOfRecipes.add(new Recipe(2,
                        "Kurczak jakis",
                        "Kurcza w sosie jakims  z ryzem",
                        LocalDate.now(),
                        "me")

                );
        listOfRecipes.add(new Recipe(3,
                        "Kurczak XD",
                        "Kurcza w sosie XD z ryzem",
                        LocalDate.now(),
                        "me")

                );
    }

    public List<Recipe> getListOfRecipes(){
        return listOfRecipes;
    }
    public void addRecipe(String recipeName, String description, String addedByUser){
        count+=1;
        listOfRecipes.add(new Recipe(count,recipeName,description,LocalDate.now(),addedByUser));

    }
}
