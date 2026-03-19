package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public User updateUser(Long id,User userDetails) {
    	
    	User user=userRepository.findById(id).orElse(null);
    	
    	if(user!=null) {
    		
    		user.setName(userDetails.getName());
    		user.setEmail(userDetails.getEmail());
    		user.setGender(userDetails.getGender());  // new field
            user.setDob(userDetails.getDob());
            user.setState(userDetails.getState());
            return userRepository.save(user);
    		
    	}
		return null;
    	
    	
    }
    
    // to search by email
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
    
    
    
      	
    	
    	
    }
