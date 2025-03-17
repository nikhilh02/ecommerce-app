package com.ecommerce.service;

import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.ProductRepositoryCustom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductRepositoryCustom productRepositoryCustom;

    public ProductServiceImpl(ProductRepository productRepository, ProductRepositoryCustom productRepositoryCustom) {
        this.productRepository = productRepository;
        this.productRepositoryCustom = productRepositoryCustom;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepositoryCustom.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepositoryCustom.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Product addProduct(Product product) {
        return productRepositoryCustom.save(product);
    }

    @Transactional
    @Override
    public void deleteProduct(Long id) {
        productRepositoryCustom.deleteById(id);
    }
}
