package com.projects.recipesservice.repo;

import com.projects.recipesservice.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
