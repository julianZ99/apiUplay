package com.example.apiuplay.services;

import com.example.apiuplay.models.User;
import com.example.apiuplay.models.UserDTO;
import com.example.apiuplay.repository.UserRepositoty;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepositoty userRepositoty;

    public UserService(UserRepositoty userRepository) {
        this.userRepositoty = userRepository;
    }

    public User saveUser(@NotNull UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getName(), userDTO.getLastname());
        return userRepositoty.save(user);
    }

    public UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setName(user.getName());
        userDTO.setLastname(user.getLastname());
        return userDTO;
    }

    public User findByUsername(String username) {
        return userRepositoty.findByUsername(username);
    }

}
