package org.example.hhjava243springweb.externalAPI.controller;

import lombok.RequiredArgsConstructor;
import org.example.hhjava243springweb.externalAPI.client.ApiResponse;
import org.example.hhjava243springweb.externalAPI.client.RickAndMortyApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final RickAndMortyApiService rickAndMortyApiService;

    @GetMapping
    public ApiResponse getAllCharacters() {
        return rickAndMortyApiService.fetchApiResponse();
    }
}
