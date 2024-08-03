package org.example.hhjava243springweb.externalAPI.client;

import org.example.hhjava243springweb.externalAPI.model.RickAndMortyCharacter;

import java.util.List;

public record ApiResponse(
        List<RickAndMortyCharacter> results
) {
}
