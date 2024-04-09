package org.example.simplemarket.repository;

import org.example.simplemarket.model.Product;
import org.example.simplemarket.repository.mappers.ProductRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final JdbcTemplate jdbc;

    public Product getProductById(long id) {
        String sql = "SELECT * FROM products WHERE id = ?;";
        return jdbc.queryForObject(sql, new ProductRowMapper(), id);
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM products;";
        return jdbc.query(sql, new ProductRowMapper());
    }

    public void changeQuantity(long id, int quantity) {
        String sql = "UPDATE products SET quantity = ? WHERE id = ?;";
        jdbc.update(sql, quantity, id);
    }

    public void save(Product product) {
        String sql = "INSERT INTO products (name, price, quantity) VALUES(?, ?, ?)";
        jdbc.update(sql, product.getName(), product.getPrice(), product.getQuantity());
    }
}
