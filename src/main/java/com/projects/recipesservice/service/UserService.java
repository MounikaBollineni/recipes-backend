package com.projects.recipesservice.service;

import com.projects.recipesservice.entity.User;
import com.projects.recipesservice.entity.UserAuth;
import com.projects.recipesservice.repo.UserAuthRepository;
import com.projects.recipesservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthRepository userAuthRepository;

    public String validateEmail(String email) throws IllegalArgumentException {

        if (userRepository.findByEmail(email).isPresent()) {
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

    public User saveUser(User user){
        String email=validateEmail(user.getEmail());
        String password=validatePassword(user.getPassword());
        user.setEmail(email);
        user.setPassword(password);
        userAuthRepository.save(new UserAuth(user.getId(), user.getEmail(), user.getPassword()));
        return userRepository.save(user);
    }
}
