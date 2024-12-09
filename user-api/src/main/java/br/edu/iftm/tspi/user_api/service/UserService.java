package br.edu.iftm.tspi.user_api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.iftm.tspi.user_api.model.User;
import br.edu.iftm.tspi.user_api.model.dto.UserDTO;
import br.edu.iftm.tspi.user_api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> dbUsers = repository.findAll();
        if (dbUsers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<UserDTO> userDtos = dbUsers.stream()
            .map(UserDTO::new)
            .collect(Collectors.toList());

        return ResponseEntity.ok(userDtos);
    }

    public ResponseEntity<UserDTO> findById(ObjectId id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        
        Optional<User> dbUser = repository.findById(id);
        return dbUser
            .map(user -> ResponseEntity.ok(new UserDTO(user)))
            .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<UserDTO> save(User user) {
        User savedUser = repository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(savedUser));
    }

    public ResponseEntity<UserDTO> update(UserDTO userDto) {
        if (userDto.getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        ObjectId objectId = new ObjectId(userDto.getId());
        Optional<User> dbUser = repository.findById(objectId);

        if (dbUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User dbUserObj = dbUser.get();
        dbUserObj.setName(userDto.getName());
        dbUserObj.setAge(userDto.getAge());

        User updatedUser = repository.save(dbUserObj);
        return ResponseEntity.ok(new UserDTO(updatedUser));
    }

    public ResponseEntity<Void> delete(ObjectId id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}