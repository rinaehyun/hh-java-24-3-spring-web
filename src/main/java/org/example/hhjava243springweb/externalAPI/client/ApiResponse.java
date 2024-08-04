package org.example.hhjava243springweb.externalAPI.client;

import java.util.List;

public record ApiResponse(
        RickAndMortyApiInfo info,
        List<RickAndMortyCharacter> results
) {
}
