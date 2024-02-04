package com.SpringCourse.Section7.Recipe;

import com.SpringCourse.Section7.Recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Integer> {
    public List<Recipe> findByAddedByUser(String addedByUser);
}
