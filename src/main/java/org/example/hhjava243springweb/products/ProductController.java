package org.example.hhjava243springweb.products;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Dependency Injection
    private final ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        List<Product> allProducts = productRepo.findAll();
        return allProducts;
    }

    @PostMapping
    public Product postProduct(@RequestBody Product product) {
        // Logic here -> if some attributes doesn't have pre-defined values
        Product productTosave = product.withPrice(5);
        //
        return productRepo.save(productTosave);
    }
}
