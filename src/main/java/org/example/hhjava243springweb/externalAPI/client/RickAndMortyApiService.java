package org.example.hhjava243springweb.externalAPI.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RickAndMortyApiService {

    private final RestClient restClient;

    public RickAndMortyApiService() {
        restClient = RestClient.builder()
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
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
