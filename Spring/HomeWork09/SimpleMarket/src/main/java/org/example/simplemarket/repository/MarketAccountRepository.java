package org.example.simplemarket.repository;

import org.example.simplemarket.model.MarketAccount;
import org.example.simplemarket.repository.mappers.MarketAccountRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MarketAccountRepository {
    private final JdbcTemplate jdbc;

    public MarketAccount getMarketAccountById(long id) {
        String sql = "SELECT * FROM market_accounts WHERE id = ?;";
        return jdbc.queryForObject(sql, new MarketAccountRowMapper(), id);
    }

    public List<MarketAccount> getAllMarketAccounts() {
        String sql = "SELECT * FROM market_accounts;";
        return jdbc.query(sql, new MarketAccountRowMapper());
    }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "UPDATE market_accounts SET amount = ? WHERE id = ?;";
        jdbc.update(sql, amount, id);
    }
}
