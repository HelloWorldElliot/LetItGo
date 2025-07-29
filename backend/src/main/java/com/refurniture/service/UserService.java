package com.refurniture.service;

import com.refurniture.model.User;
import com.refurniture.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAll() { return repo.findAll(); }

    public User getById(Long id) { return repo.findById(id).orElse(null); }

    public User create(User user) { return repo.save(user); }

    public User update(Long id, User updated) {
        User user = repo.findById(id).orElse(null);
        if (user == null) return null;
        user.setUsername(updated.getUsername());
        user.setEmail(updated.getEmail());
        user.setPasswordHash(updated.getPasswordHash());
        return repo.save(user);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
