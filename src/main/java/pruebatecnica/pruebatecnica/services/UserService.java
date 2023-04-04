package pruebatecnica.pruebatecnica.services;

import org.springframework.stereotype.Service;
import pruebatecnica.pruebatecnica.models.User;
import pruebatecnica.pruebatecnica.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User findById(Long idUser) {
        Optional<User> user = repository.findById(idUser);
        return user.orElse(null);
    }

    public User save(User newUser) {
        return repository.save(newUser);
    }

    public User update(User newUser, Long idUser) {
        Optional<User> user = repository.findById(idUser);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setUsername(newUser.getUsername());
            existingUser.setPassword(newUser.getPassword());
            return repository.save(existingUser);
        } else {
            return null;
        }
    }

    public boolean delete(Long idUser) {
        Optional<User> user = repository.findById(idUser);
        if (user.isPresent()) {
            repository.delete(user.get());
            return true;
        } else {
            return false;
        }
    }
}
