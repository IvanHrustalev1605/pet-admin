package com.example.petadmin.dao.adbstract.model;

import com.example.petadmin.models.entity.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
