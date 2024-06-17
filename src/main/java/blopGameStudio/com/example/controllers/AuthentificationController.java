package blopGameStudio.com.example.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import blopGameStudio.com.example.models.User;
import blopGameStudio.com.example.repositories.UserRepository;



@RestController
public class AuthentificationController {




    private final UserRepository userRepository; 

        @Value("${myApp.BearerHeader}")
        private  String BearerPrefix;

    public AuthentificationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void postUser(@RequestBody User user) {
        userRepository.save(user);   
}

      @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
        
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public  Map<String, String> login(@RequestParam("username") String username,@RequestParam("password") String password) {

        User userFromDB  =userRepository.findByPseudo(username);
        if(userFromDB != null && userFromDB.getPassword().equals(password)){
            Map<String, String> response = new HashMap<>();
            response.put("access_token", userFromDB.getId());
            return response;
        }
        else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }
    }

    /* 
    @GetMapping("/User")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto User(@RequestHeader("Authorization") String BearerHeader){
        String userUUID=BearerHeader.substring(BearerPrefix.length());
        return userRepository.findById(userUUID).map(this::toUserDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private UserDto toUserDto(User user){
        return new UserDto(user.getPseudo(), user.getEmail(), user.getPokedollars());
    }
    */
   


  //  @PutMapping("/deleteAccount")
 //   @ResponseStatus(HttpStatus.OK)
  // public void updateUser(
   //    @RequestHeader("Authorization") String BearerHeader,@RequestParam String password) {
        //    String userUUID=BearerHeader.substring(BearerPrefix.length());
        //    User user = userRepository.findById(userUUID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        //                   if(user.getPassword().equals(password)){
        //                    System.out.println("ici");
        //            userRepository.deleteById(userUUID);
        //        }
      
   //}
  
        

  

}
