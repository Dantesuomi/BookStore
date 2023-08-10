package org.bookstore.services;

import org.bookstore.entities.User;
import org.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Pattern;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isValidPassword(String password) {
        // must include number, upper and lower case character and min length of 8
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        Pattern regex = Pattern.compile(pattern);
        return regex.matcher(password).matches();
    }

    public boolean isValidEmail(String email){
        String pattern = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        Pattern regex = Pattern.compile(pattern);
        return regex.matcher(email).matches();
    }

    public User getUser(Long id){
        return userRepository.getUserById(id);
    }

    public boolean isUsernameInUse(String username) {
        User userByUsername = userRepository.findByUsername(username);
        if(userByUsername !=null)
            return true;
        return false;
    }

    public boolean isEmailInUse(String email) {
        User userByEmail = userRepository.findByEmail(email);
        if(userByEmail != null)
            return true;
        return false;
    }


}
