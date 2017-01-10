package com.betterfy.service;

import com.betterfy.entity.User;
import com.betterfy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nik on 1/10/17.
 */

@Component
public class UserService {

    private static UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public static boolean createUser(User user){
        try {

            userRepository.save(user);
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }

    /*
    @Autowired
    private static UserRepository userRepository;
    */


}
