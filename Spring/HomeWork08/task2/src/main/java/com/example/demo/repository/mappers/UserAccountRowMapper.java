package com.example.demo.repository.mappers;

import com.example.demo.model.UserAccount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountRowMapper implements RowMapper<UserAccount> {
    @Override
    public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(rs.getInt("id"));
        userAccount.setName(rs.getString("name"));
        userAccount.setAmount(rs.getBigDecimal("amount"));
        return userAccount;
    }
}
