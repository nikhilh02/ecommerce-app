package com.ecommerce.service;

import com.ecommerce.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product addProduct(Product product);
    void deleteProduct(Long id);
}
