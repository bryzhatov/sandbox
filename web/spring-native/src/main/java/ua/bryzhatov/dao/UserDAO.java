package ua.bryzhatov.dao;


import ua.bryzhatov.entity.User;

import java.util.List;

/**
 * В DAO описываем CRUD операции
 * Реализация будет описываться в бине
 */
public interface UserDAO {
    User getById(int id);
    void update(User user);
    void save(User user);
    void delete(int id);
    List<User> findAll();
}
