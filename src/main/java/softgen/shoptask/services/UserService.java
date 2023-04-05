package softgen.shoptask.services;
import softgen.shoptask.entities.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(int id);
}