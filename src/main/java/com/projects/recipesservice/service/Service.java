package com.projects.recipesservice.service;

import com.projects.recipesservice.entity.Image;
import com.projects.recipesservice.entity.Recipe;
import com.projects.recipesservice.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository repository;
    public Recipe saveRecipe(Recipe recipe) {
        return repository.save(recipe);
    }
}
