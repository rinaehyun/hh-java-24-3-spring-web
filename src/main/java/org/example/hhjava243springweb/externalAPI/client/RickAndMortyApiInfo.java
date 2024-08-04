package org.example.hhjava243springweb.externalAPI.client;

public record RickAndMortyApiInfo(
        int count,
        int pages,
        String next,
        String prev
) {
}
