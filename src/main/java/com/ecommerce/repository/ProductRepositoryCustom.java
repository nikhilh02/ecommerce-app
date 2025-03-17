package com.ecommerce.repository;

import com.ecommerce.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepositoryCustom {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
}
