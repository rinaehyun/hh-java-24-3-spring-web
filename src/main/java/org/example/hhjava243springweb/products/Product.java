package org.example.hhjava243springweb.products;

import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
@With
public record Product(
        String id,
        String title,
        String description,
        int price
) {
}
