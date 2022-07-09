package racemanagement.trektrak.Controller;

import org.springframework.web.bind.annotation.RestController;

import racemanagement.trektrak.Entity.User;
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

    List<User> users = new ArrayList<User>();

    public BasicAuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/all")
	public List<User> getAllUsers() {
        System.out.print("Retrieving All Exisiting Users...");
		return userService.getAllUsers();
	}

    @PostMapping("/user/new")
    public void saveNewUser(@RequestBody User newUser) {
        System.out.println("Updated/New User Recieved: ID = " + newUser.getId());
        System.out.println("Updated/New User Recieved: Username = " + newUser.getUsername());
        System.out.println("Updated/New User Recieved: Password = " + newUser.getPassword());
        System.out.println("New/Updated User Recieved: Email = " + newUser.getEmail());
        userService.saveNewUser(newUser);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        System.out.println("Deleting User by ID: ID = " + id);
        userService.deleteUser(id);
    }

    @PutMapping("/user/update")
    public void updateUser(@RequestBody User updatedUser) {
        System.out.println("Updated/New User Recieved: ID = " + updatedUser.getId());
        System.out.println("Updated/New User Recieved: Username = " + updatedUser.getUsername());
        System.out.println("Updated/New User Recieved: Password = " + updatedUser.getPassword());
        System.out.println("Updated/New User Recieved: Email = " + updatedUser.getEmail());
        userService.updateUser(updatedUser);
    }

    @GetMapping("/user/populate")
    public String populateDBwithTestData() {
        System.out.println("Populating In-Memory Database with Test Users...");
        users.add(new User(1, "gusmccoy", "@Badgerrunner1!", "gus@gusmccoy.dev"));

        users.forEach(User -> userService.saveNewUser(User));

        return "populated";
    }
}
