package com.example.demo.controller;

import com.example.demo.model.State;
import com.example.demo.model.User;
import com.example.demo.repository.StateRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StateRepository stateRepository;
    
    @Autowired
    private UserRepository userRepository;

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getUsers(
            @RequestParam(required = false) Integer stateId) {

        List<User> users;

        if(stateId != null){
            users = userRepository.findByState_StateCode(stateId);
        } else {
            users = userRepository.findAll();
        }

        return ResponseEntity.ok(users);
    }
    
    

    // Get user by id
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    // Get user by email
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    // Add new user
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user){
        try {

            // ✅ Check duplicate email FIRST
            if(userService.existsByEmail(user.getEmail())){
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body("Email already exists");
            }

            // ✅ Fetch state safely
            Integer stateCode = user.getState().getStateCode();

            State state = stateRepository.findById(stateCode)
                    .orElseThrow(() -> new RuntimeException("State not found"));

            user.setState(state);

            User savedUser = userService.createUser(user);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);

        } 
        catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
        try {
            Integer stateCode = userDetails.getState().getStateCode();
            State state = stateRepository.findById(stateCode)
                            .orElseThrow(() -> new RuntimeException("State not found"));
            userDetails.setState(state);
            
            User updatedUser = userService.updateUser(id, userDetails);
            if (updatedUser != null) {
                return ResponseEntity.ok(updatedUser);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/check-email")
    public boolean checkEmail(@RequestParam String email){
        return userRepository.existsByEmail(email);
    }
}
