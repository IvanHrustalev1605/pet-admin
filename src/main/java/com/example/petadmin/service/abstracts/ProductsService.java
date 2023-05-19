package com.example.petadmin.service.abstracts;

import com.example.petadmin.models.entity.products.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    void create(Product product);
    List<Product> allProducts();
    Optional<Product> findBiId(Long id);
    List<Product> findByName(String name);
    void deleteProductById(Long id);
    Product update(Long id);

}
