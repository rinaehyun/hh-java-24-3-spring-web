package org.example.hhjava243springweb.externalAPI;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RickMortyApiServiceTest {

    @Autowired
    private MockMvc mockMvc;
    private static MockWebServer mockWebServer;

    @BeforeAll
    static void beforeAll() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    static void afterAll() throws IOException {
        mockWebServer.shutdown();
    }

    @DynamicPropertySource
    static void dynamicProperties(DynamicPropertyRegistry registry) {
        registry.add("app.rickandmorty.api.url", () -> mockWebServer.url("/").toString());
    }


    @Test
    public void fetchApiResponseTeat() throws Exception {

        mockWebServer.enqueue(new MockResponse()
                .setBody("""
                            [{
                                "info": {
                                    "count": 826,
                                    "pages": 42,
                                    "next": "https://rickandmortyapi.com/api/character?page=2",
                                    "prev": null
                                },
                                "results": [
                                                {
                                                    "id": "1",
                                                    "name": "Rick Sanchez",
                                                    "status": "Alive",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "2",
                                                    "name": "Morty Smith",
                                                    "status": "Alive",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "3",
                                                    "name": "Summer Smith",
                                                    "status": "Alive",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "4",
                                                    "name": "Beth Smith",
                                                    "status": "Alive",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "5",
                                                    "name": "Jerry Smith",
                                                    "status": "Alive",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "6",
                                                    "name": "Abadango Cluster Princess",
                                                    "status": "Alive",
                                                    "species": "Alien"
                                                },
                                                {
                                                    "id": "7",
                                                    "name": "Abradolf Lincler",
                                                    "status": "unknown",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "8",
                                                    "name": "Adjudicator Rick",
                                                    "status": "Dead",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "9",
                                                    "name": "Agency Director",
                                                    "status": "Dead",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "10",
                                                    "name": "Alan Rails",
                                                    "status": "Dead",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "11",
                                                    "name": "Albert Einstein",
                                                    "status": "Dead",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "12",
                                                    "name": "Alexander",
                                                    "status": "Dead",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "13",
                                                    "name": "Alien Googah",
                                                    "status": "unknown",
                                                    "species": "Alien"
                                                },
                                                {
                                                    "id": "14",
                                                    "name": "Alien Morty",
                                                    "status": "unknown",
                                                    "species": "Alien"
                                                },
                                                {
                                                    "id": "15",
                                                    "name": "Alien Rick",
                                                    "status": "unknown",
                                                    "species": "Alien"
                                                },
                                                {
                                                    "id": "16",
                                                    "name": "Amish Cyborg",
                                                    "status": "Dead",
                                                    "species": "Alien"
                                                },
                                                {
                                                    "id": "17",
                                                    "name": "Annie",
                                                    "status": "Alive",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "18",
                                                    "name": "Antenna Morty",
                                                    "status": "Alive",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "19",
                                                    "name": "Antenna Rick",
                                                    "status": "unknown",
                                                    "species": "Human"
                                                },
                                                {
                                                    "id": "20",
                                                    "name": "Ants in my Eyes Johnson",
                                                    "status": "unknown",
                                                    "species": "Human"
                                                }
                                ]
                            }]
                        """)
                .addHeader("Content-Type", "application/json")
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/api/characters"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                          {
                            "info": {
                                        "count": 826,
                                        "pages": 42,
                                        "next": "https://rickandmortyapi.com/api/character?page=2",
                                        "prev": null
                                    },
                             "results": [
                                {
                                    "id": "1",
                                    "name": "Rick Sanchez",
                                    "status": "Alive",
                                    "species": "Human"
                                },
                                {
                                    "id": "2",
                                    "name": "Morty Smith",
                                    "status": "Alive",
                                    "species": "Human"
                                },
                                {
                                    "id": "3",
                                    "name": "Summer Smith",
                                    "status": "Alive",
                                    "species": "Human"
                                },
                                {
                                    "id": "4",
                                    "name": "Beth Smith",
                                    "status": "Alive",
                                    "species": "Human"
                                },
                                {
                                    "id": "5",
                                    "name": "Jerry Smith",
                                    "status": "Alive",
                                    "species": "Human"
                                },
                                {
                                    "id": "6",
                                    "name": "Abadango Cluster Princess",
                                    "status": "Alive",
                                    "species": "Alien"
                                },
                                {
                                    "id": "7",
                                    "name": "Abradolf Lincler",
                                    "status": "unknown",
                                    "species": "Human"
                                },
                                {
                                    "id": "8",
                                    "name": "Adjudicator Rick",
                                    "status": "Dead",
                                    "species": "Human"
                                },
                                {
                                    "id": "9",
                                    "name": "Agency Director",
                                    "status": "Dead",
                                    "species": "Human"
                                },
                                {
                                    "id": "10",
                                    "name": "Alan Rails",
                                    "status": "Dead",
                                    "species": "Human"
                                },
                                {
                                    "id": "11",
                                    "name": "Albert Einstein",
                                    "status": "Dead",
                                    "species": "Human"
                                },
                                {
                                    "id": "12",
                                    "name": "Alexander",
                                    "status": "Dead",
                                    "species": "Human"
                                },
                                {
                                    "id": "13",
                                    "name": "Alien Googah",
                                    "status": "unknown",
                                    "species": "Alien"
                                },
                                {
                                    "id": "14",
                                    "name": "Alien Morty",
                                    "status": "unknown",
                                    "species": "Alien"
                                },
                                {
                                    "id": "15",
                                    "name": "Alien Rick",
                                    "status": "unknown",
                                    "species": "Alien"
                                },
                                {
                                    "id": "16",
                                    "name": "Amish Cyborg",
                                    "status": "Dead",
                                    "species": "Alien"
                                },
                                {
                                    "id": "17",
                                    "name": "Annie",
                                    "status": "Alive",
                                    "species": "Human"
                                },
                                {
                                    "id": "18",
                                    "name": "Antenna Morty",
                                    "status": "Alive",
                                    "species": "Human"
                                },
                                {
                                    "id": "19",
                                    "name": "Antenna Rick",
                                    "status": "unknown",
                                    "species": "Human"
                                },
                                {
                                    "id": "20",
                                    "name": "Ants in my Eyes Johnson",
                                    "status": "unknown",
                                    "species": "Human"
                                }
                              ]
                          }
                        """));
    }
}
