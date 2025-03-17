package com.ecommerce.repository;

import com.ecommerce.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
@Transactional
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Product.class, id));
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
            return product;
        } else {
            return entityManager.merge(product);
        }
    }

    @Override
    public void deleteById(Long id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}
