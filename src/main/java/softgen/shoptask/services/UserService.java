package softgen.shoptask.services;

import org.springframework.stereotype.Service;
import softgen.shoptask.entities.User;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsers();
    User getUserById(int id);
}