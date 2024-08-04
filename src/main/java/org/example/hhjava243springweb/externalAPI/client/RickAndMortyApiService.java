package org.example.hhjava243springweb.externalAPI.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RickAndMortyApiService {

    private final RestClient restClient;

    public RickAndMortyApiService(@Value("${app.rickandmorty.api.url}") String baseUrl) {
        restClient = RestClient.create(baseUrl);
    }

    public ApiResponse fetchApiResponse() {
        ApiResponse apiResponse = restClient
                .get()
                .uri("/character")
                .retrieve()
                .body(ApiResponse.class);
        
        return apiResponse;
    }
}
