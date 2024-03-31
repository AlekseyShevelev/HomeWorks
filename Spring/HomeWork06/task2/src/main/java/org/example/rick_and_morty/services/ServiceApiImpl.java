package org.example.rick_and_morty.services;

import lombok.RequiredArgsConstructor;
import org.example.rick_and_morty.model.Characters;
import org.example.rick_and_morty.model.Result;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceApiImpl implements ServiceApi {
    private final RestTemplate template;
    private final HttpHeaders headers;
    private final Api api;

    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(
                api.getCharacter(),
                HttpMethod.GET,
                entity,
                Characters.class);

        return response.getBody();
    }

    @Override
    public Result getCharacterById(Integer id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Result> response = template.exchange(
                api.getCharacter() + "/" + id,
                HttpMethod.GET,
                entity,
                Result.class);

        return response.getBody();
    }
}
