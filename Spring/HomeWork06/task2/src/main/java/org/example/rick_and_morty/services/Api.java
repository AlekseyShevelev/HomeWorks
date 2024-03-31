package org.example.rick_and_morty.services;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api")
@Data
public class Api {
    private String character;
}
