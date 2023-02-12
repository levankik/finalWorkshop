package softgen.shoptask.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softgen.shoptask.entities.User;
import softgen.shoptask.services.UserService;

import java.util.List;
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("")
    public List<User> getUsers() { return userService.getUsers();}

    @GetMapping("/{id}")
    public User  getUser(@PathVariable int id)  {
        System.out.println(passwordEncoder.encode("vano"));
        return userService.getUserById(id);
    }
}
