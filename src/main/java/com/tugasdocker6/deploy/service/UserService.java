package com.tugasdocker6.deploy.service;

import com.tugasdocker6.deploy.model.User;
import com.tugasdocker6.deploy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public User addUser(User request){
        request.setId(UUID.randomUUID().toString());
        return userRepository.save(request);
    }

    public List<User> getAllUsers() { return userRepository.findAll();}


}
