package com.example.demo.repositories;

import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий пользователя
 */
@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    /**
     * Конструктор репозитория пользователя
     */
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<User> userRowMapper = (rs, rn) -> {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        return user;
    };

    /**
     * Получение списка всех пользователей.
     *
     * @return список пользователей
     */
    public List<User> getAll() {
        String sql = "SELECT * FROM userTable";
        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Получение пользователя по идентификатору.
     *
     * @param id идентификатор пользователя
     * @return объект пользователя
     */
    public User getOne(int id) {
        String sql = "SELECT * FROM userTable WHERE id=?";
        return jdbc.queryForObject(sql, userRowMapper, id);
    }

    /**
     * Добавление пользователя.
     *
     * @param user объект пользователя
     * @return объект пользователя
     */
    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName, lastName) VALUES(?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Удаление пользователя по идентификатору.
     *
     * @param id идентификатор пользователя
     */
    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /**
     * Изменение пользователя.
     *
     * @param user объект пользователя
     */
    public void update(User user) {
        String sql = "UPDATE userTable SET firstName=?, lastName=? WHERE id=?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }
}
