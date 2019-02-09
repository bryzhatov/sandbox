package ua.bryzhatov.service;

import ua.bryzhatov.entity.User;

import java.util.List;

/**
 * Сервисы хранят бизнесс логику
 */
public interface UserService {
    User getById(int id);
    void update(User user);
    void save(User user);
    void delete(int id);
    List<User> findAll();
}
