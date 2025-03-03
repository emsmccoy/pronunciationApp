package dev.pronunciationAppBack.service;

import dev.pronunciationAppBack.model.UserApp;
import dev.pronunciationAppBack.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserAppRepository userRepository;
    
    public List<UserApp> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserApp> getUserById(String id) {
        return Optional.ofNullable(userRepository.getUserById(id));
    }

    public UserApp createUser(UserApp user) {
        return userRepository.save(user);
    }

    public UserApp updateUser(UserApp user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }

    public long getUserCount() {
        return userRepository.count();
    }

}
