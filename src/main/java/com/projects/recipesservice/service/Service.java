package com.projects.recipesservice.service;

import com.projects.recipesservice.entity.Image;
import com.projects.recipesservice.entity.Recipe;
import com.projects.recipesservice.entity.UserEntity;
import com.projects.recipesservice.repo.Repository;
import com.projects.recipesservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private UserRepo userRepo;

    public String validateEmail(String email) throws IllegalArgumentException {

        if (userRepo.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already registered!");
        }

        String regex = "^(?=.{1,64}@)[A-Za-z\\d_-]+(\\.[A-Za-z\\d_-]+)*@"
                + "[^-][A-Za-z\\d-]+(\\.[A-Za-z\\d-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return email;
        }
        throw new IllegalArgumentException("Please Enter a Valid Email!");
    }

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
    public UserEntity saveRecipe(UserEntity user) {

        user.setEmail(validateEmail(user.getEmail()));
        return userRepo.save(user);
    }
}
