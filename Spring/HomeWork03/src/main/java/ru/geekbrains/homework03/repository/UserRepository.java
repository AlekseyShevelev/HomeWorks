package ru.geekbrains.homework03.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.geekbrains.homework03.domain.User;

//import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий пользователя
 */
@Repository
public class UserRepository {
    //    private final List<User> users = new ArrayList<>();
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<User> userRowMapper = (rs, rn) -> {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        user.setEmail(rs.getString("email"));
        return user;
    };

    /**
     * Получение списка пользователей
     * @return список пользователей
     */
    public List<User> getUsers() {
//        return users;
        String sql = "SELECT * FROM users";
        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Добавление пользователя
     * @param user объект пользователя
     */
    public void addUser(User user) {
//        users.add(user);
        String sql = "INSERT INTO users (name, age, email) VALUES (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }
}
