package softgen.shoptask.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softgen.shoptask.ecxeptions.NotFoundException;
import softgen.shoptask.entities.User;
import softgen.shoptask.repositories.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow (() -> new NotFoundException("User not found"));
    }
}