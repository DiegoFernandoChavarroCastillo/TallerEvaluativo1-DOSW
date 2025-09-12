package com.taller1.controller;
import com.taller1.model.Product;
import com.taller1.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        service.addProduct(product);
    }

    @PutMapping("/{name}/stock")
    public void updateStock(@PathVariable String name, @RequestParam int stock) {
        service.updateStock(name, stock);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getProducts();
    }
}

