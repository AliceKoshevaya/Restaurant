package ua.nure.koshova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.nure.koshova.entity.Product;
import ua.nure.koshova.service.ProductService;

@RestController
public class ProductController {

//    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public int createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PutMapping("/products")
    public boolean updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}


