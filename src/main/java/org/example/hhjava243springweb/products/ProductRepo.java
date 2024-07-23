package org.example.hhjava243springweb.products;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends MongoRepository<Product, String> {
    // List<Product> products = new ArrayList<>(); -> will be stored in db
    // addtional methods regarding the db and class will be modified here.
}
