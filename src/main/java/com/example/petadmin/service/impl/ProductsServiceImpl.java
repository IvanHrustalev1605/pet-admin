package com.example.petadmin.service.impl;

import com.example.petadmin.dao.adbstract.model.ProductsRepository;
import com.example.petadmin.exception.NotFoundException;
import com.example.petadmin.models.entity.products.Product;
import com.example.petadmin.service.abstracts.ProductsService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ProductsServiceImpl implements ProductsService {
    private final ProductsRepository productsRepository;
    @PersistenceContext
    public EntityManager entityManager;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public void create(Product product) {
        productsRepository.save(product);
    }

    @Override
    @SneakyThrows
    public List<Product> allProducts() {
        if (productsRepository.findAll().isEmpty()) {
            throw new NotFoundException();
        }
        return productsRepository.findAll();
    }

    @Override
    @SneakyThrows
    public Optional<Product> findBiId(Long id) {
        if (productsRepository.findById(id).isEmpty()) {
            throw new NotFoundException();
        }
        return productsRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> resultList = entityManager.createQuery("""
                        FROM Product p
                        WHERE p.name =: name
                        """, Product.class)
                .setParameter("name", name)
                .getResultList();
        return resultList;
    }

    @Override
    public void deleteProductById(Long id) {
        if (!findBiId(id).isEmpty()) {
            productsRepository.deleteById(id);
        }
    }

    @Override
    public Product update(Long id) {
        return null;
    }
}
