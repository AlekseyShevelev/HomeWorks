package org.example.rick_and_morty.services;

import org.example.rick_and_morty.model.Characters;
import org.example.rick_and_morty.model.Result;

public interface ServiceApi {
    Characters getAllCharacters();
    Result getCharacterById(Integer id);
}
