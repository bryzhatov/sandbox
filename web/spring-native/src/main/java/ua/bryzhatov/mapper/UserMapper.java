package ua.bryzhatov.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.bryzhatov.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    /**
     * Для каждого ряда который достанет JDBC мы (в этом методе) говорим:
     */
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setAge(resultSet.getInt("age"));
        return user;
    }
}
