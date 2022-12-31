package com.projects.recipesservice.controller;

import com.projects.recipesservice.entity.Image;
import com.projects.recipesservice.entity.Recipe;
import com.projects.recipesservice.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/recipes")
public class Controller {
    @Autowired
    private Service service;

    @PostMapping(value = "/save-recipe", consumes ={MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE} )
    public Recipe saveRecipe(@RequestPart("recipe") Recipe recipe,
                            @RequestPart("image") MultipartFile[] files){
        try {
            Set<Image> images=uploadImage(files);
            recipe.setImages(images);
            return service.saveRecipe(recipe);
        }catch (Exception e){
            System.out.println("exception");
            return null;
        }
    }

    public Set<Image> uploadImage(MultipartFile[] imageFiles) throws IOException {
        Set<Image> images=new HashSet<>();

        for (MultipartFile file :imageFiles){
            Image image=new Image(file.getBytes());
            images.add(image);
        }
        return images;
    }
}
