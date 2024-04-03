package com.example.demo.repository;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.mappers.UserAccountRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserAccountRepository {
    private final JdbcTemplate jdbc;

    public UserAccount getUserAccountById(long id) {
        String sql = "SELECT * FROM user_accounts WHERE id = ?;";
        return jdbc.queryForObject(sql, new UserAccountRowMapper(), id);
    }

    public List<UserAccount> getAllUserAccounts() {
        String sql = "SELECT * FROM user_accounts;";
        return jdbc.query(sql, new UserAccountRowMapper());
    }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "UPDATE user_accounts SET amount = ? WHERE id = ?;";
        jdbc.update(sql, amount, id);
    }
}
