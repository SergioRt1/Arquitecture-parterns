package edu.arep.EC2.services;

import edu.arep.EC2.entities.User;
import edu.arep.EC2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int save(User user) {
        return userRepository.save(user);
    }

    public User getById(int userId) {
        return userRepository.getById(userId);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }
}
