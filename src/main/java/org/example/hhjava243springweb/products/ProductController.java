package org.example.hhjava243springweb.products;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    // Dependency Injection
    private final ProductService productService;

    //public ProductController(ProductRepo productRepo) {
    //    this.productRepo = productRepo;
    //}

    @GetMapping
    public List<Product> getAllProducts() {
        List<Product> allProducts = productService.findAllProducts();
        return allProducts;
    }

    @PostMapping
    public Product postProduct(@RequestBody NewProductDto product) {
        return productService.saveProduct(product);
    }
}
