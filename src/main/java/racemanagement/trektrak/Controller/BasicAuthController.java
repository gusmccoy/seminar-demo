package racemanagement.trektrak.Controller;

import org.springframework.web.bind.annotation.RestController;

import racemanagement.trektrak.DTO.LoginRequestResponseDTO;
import racemanagement.trektrak.Entity.ApplicationUser;
import racemanagement.trektrak.Service.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "https://www.trek-trak.gusmccoy.dev"})
@RestController
public class BasicAuthController {

    private UserService userService;

    List<ApplicationUser> users = new ArrayList<ApplicationUser>();

    public BasicAuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/all")
	public List<ApplicationUser> getAllUsers() {
		return userService.getAllUsers();
	}

    @PostMapping("/user/authenicate")
	public LoginRequestResponseDTO validateLogin(@RequestBody ApplicationUser loginAttempt) {
		return userService.isUserInvalid(loginAttempt);
	}

    @PostMapping("/user/new")
    public void saveNewUser(@RequestBody ApplicationUser newUser) {
        userService.saveNewUser(newUser);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PutMapping("/user/update")
    public void updateUser(@RequestBody ApplicationUser updatedUser) {
        userService.updateUser(updatedUser);
    }
}
