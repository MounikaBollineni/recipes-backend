package com.projects.recipesservice.controller;

import com.projects.recipesservice.entity.UserEntity;
import com.projects.recipesservice.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@CrossOrigin
@RequestMapping("/recipes/")
public class Controller {
    @Autowired
    private Service service;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public String validatePassword(String password) {
        String regex = "^(?=.*\\d)" +
                "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            return password;
        }
        throw new IllegalArgumentException("Please Enter a valid Password!");
    }

    @PostMapping("add-user")
    private UserEntity saveRecipe(@Validated @RequestBody UserEntity user){
        String password=validatePassword(user.getPassword());
//        String encodedPassword= passwordEncoder.encode(password);
        user.setPassword(password);
        return service.saveRecipe(user);
    }


//    @PostMapping(value = "/save-recipe", consumes ={MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE} )
//    public Recipe saveRecipe(@RequestPart("recipe") Recipe recipe,
//                            @RequestPart("image") MultipartFile[] files){
//        try {
//            Set<Image> images=uploadImage(files);
//            recipe.setImages(images);
//            return service.saveRecipe(recipe);
//        }catch (Exception e){
//            System.out.println("exception");
//            return null;
//        }
//    }
//
//    public Set<Image> uploadImage(MultipartFile[] imageFiles) throws IOException {
//        Set<Image> images=new HashSet<>();
//
//        for (MultipartFile file :imageFiles){
//            Image image=new Image(file.getBytes());
//            images.add(image);
//        }
//        return images;
//    }
}
