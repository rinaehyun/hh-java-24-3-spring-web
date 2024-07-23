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

    @Test
    @DirtiesContext
    void getAllProducts() throws Exception {
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
