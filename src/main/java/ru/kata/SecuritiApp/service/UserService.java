package ru.kata.SecuritiApp.service;







import ru.kata.SecuritiApp.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser (int id);
    void save(User user);
    void update(User updatedUser);
    void delete(int id);


}

