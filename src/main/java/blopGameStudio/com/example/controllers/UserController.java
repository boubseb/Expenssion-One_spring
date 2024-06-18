package blopGameStudio.com.example.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import blopGameStudio.com.example.models.User;
import blopGameStudio.com.example.repositories.UserRepository;

@RestController
public class UserController {

        private final UserRepository userRepository; 

        @Value("${myApp.BearerHeader}")
        private  String BearerPrefix;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



      @GetMapping("/profil")
    public ResponseEntity<User> getUserById(@RequestHeader("Authorization") String BearerHeader) {
        String userUUID=BearerHeader.substring(BearerPrefix.length());
        Optional<User> userOptional = userRepository.findById(userUUID);
        if (userOptional.isPresent()) {
            User user = userOptional.get();   
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
