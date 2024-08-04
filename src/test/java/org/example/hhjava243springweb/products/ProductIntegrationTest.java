package org.example.hhjava243springweb.products;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductRepo productRepo;

    @Test
    @DirtiesContext
    void getAllProductsTest_returnEmpty() throws Exception {
        // GIVEN

        // WHEN
        mockMvc.perform(get("/api/products"))

                // THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        []
                    """));
    }

    @Test
    @DirtiesContext
    void getAllProductsTest_returnJsonArray() throws Exception {
        // GIVEN
        productRepo.save(new Product("1", "Apple", "Good", 5));
        productRepo.save(new Product("2", "Banana", "Very good", 10));
        // WHEN
        mockMvc.perform(get("/api/products"))

                // THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                            {
                                "id": "1",
                                "title": "Apple",
                                "description": "Good",
                                "price": 5
                            },
                            {
                                "id": "2",
                                "title": "Banana",
                                "description": "Very good",
                                "price": 10
                            }
                        ]
                        """));
    }

    @Test
    @DirtiesContext
    void postProduct() throws Exception {
        // GIVEN

        // WHEN
        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "title": "Banana",
                            "description": "auch lecker"
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                            "title": "Banana",
                            "description": "auch lecker",
                            "price": 5
                        }
                        """));
    }
}
