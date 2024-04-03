package com.example.demo.repository.mappers;

import com.example.demo.model.MarketAccount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarketAccountRowMapper implements RowMapper<MarketAccount> {
    @Override
    public MarketAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
        MarketAccount marketAccount = new MarketAccount();
        marketAccount.setId(rs.getInt("id"));
        marketAccount.setName(rs.getString("name"));
        marketAccount.setAmount(rs.getBigDecimal("amount"));
        return marketAccount;
    }
}
