package org.example.hhjava243springweb.externalAPI.controller;

import lombok.RequiredArgsConstructor;
import org.example.hhjava243springweb.externalAPI.client.RickAndMortyApiService;
import org.example.hhjava243springweb.externalAPI.model.RickAndMortyCharacter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final RickAndMortyApiService rickAndMortyApiService;

    @GetMapping
    public List<RickAndMortyCharacter> getAllCharacters() {
        return rickAndMortyApiService.fetchApiResponse().results();
    }
}
