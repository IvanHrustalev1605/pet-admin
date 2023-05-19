package com.example.petadmin.controllers.rest;

import com.example.petadmin.models.entity.products.Product;
import com.example.petadmin.service.abstracts.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ApiProductsController {
    private final ProductsService productsService;

    public ApiProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productsService.allProducts(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity addProduct(@RequestBody Product product) {
        productsService.create(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = productsService.findBiId(id).get();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<List<Product>> findProductByName(@PathVariable String name) {
        List<Product> byName = productsService.findByName(name);
        return new ResponseEntity<>(byName, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProductById(@PathVariable Long id) {
        productsService.deleteProductById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
