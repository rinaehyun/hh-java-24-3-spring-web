package org.example.hhjava243springweb.externalAPI.client;

import java.util.List;
import org.example.hhjava243springweb.externalAPI.model.Character;

public record ApiResponse(
        RickAndMortyApiInfo info,
        List<Character> results
) {
}
