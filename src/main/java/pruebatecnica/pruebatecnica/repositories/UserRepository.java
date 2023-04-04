package pruebatecnica.pruebatecnica.repositories;

import java.util.Optional;

import pruebatecnica.pruebatecnica.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findById(Long userId);
}
