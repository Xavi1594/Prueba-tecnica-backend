package pruebatecnica.pruebatecnica.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pruebatecnica.pruebatecnica.models.User;
import pruebatecnica.pruebatecnica.services.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<User> findById(@PathVariable Long idUser) {
        User user = service.findById(idUser);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> store(@RequestBody User newUser) {
        try {
            User savedUser = service.save(newUser);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<User> update(@RequestBody User newUser, @PathVariable Long idUser) {
        User updatedUser = service.update(newUser, idUser);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<Void> delete(@PathVariable Long idUser) {
        boolean deleted = service.delete(idUser);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
