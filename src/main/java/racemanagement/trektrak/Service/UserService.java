package racemanagement.trektrak.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import racemanagement.trektrak.DTO.LoginRequestResponseDTO;
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

    public LoginRequestResponseDTO isUserInvalid(ApplicationUser requestedUser) {
        var users = userRepository.findAllByUsername(requestedUser.getUsername());

        if(users.isPresent() && !users.get().isEmpty()) {
            return new LoginRequestResponseDTO(users.get().get(0).getId(),
                users.get().get(0).getPassword());
        } else {
            return new LoginRequestResponseDTO(-1, "");
        }
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
