package com.projects.recipesservice.repo;

import com.projects.recipesservice.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Recipe, Long> {
}
