package com.example.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sql.queries.user")
@Data
public class UserQueries {
    private String selectAll;
    private String selectOne;
    private String insert;
    private String delete;
    private String update;
}
