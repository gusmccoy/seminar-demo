package racemanagement.trektrak.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import racemanagement.trektrak.Entity.ApplicationUser;
import racemanagement.trektrak.Repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public List<ApplicationUser> getAllUsers() {
        return (List<ApplicationUser>) userRepository.findAll();
    }

    public boolean isUserInvalid(ApplicationUser user) {
        return userRepository
        .findAllByUsernameAndPassword(user.getUsername(), user.getPassword()).isEmpty();
    }

    public void saveNewUser(ApplicationUser newUser) {
        userRepository.save(newUser);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public void updateUser(ApplicationUser updatedUser) {
        userRepository.save(updatedUser);
    }
}
