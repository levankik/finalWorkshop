package softgen.shoptask.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softgen.shoptask.configurations.SecUser;
import softgen.shoptask.entities.User;
import softgen.shoptask.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

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
