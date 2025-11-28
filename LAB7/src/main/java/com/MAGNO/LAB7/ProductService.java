package com.MAGNO.LAB7;

import com.MAGNO.LAB7.Product;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

    @Service
    public class ProductService {

        private Map<Long, Product> productRepo = new HashMap<>();
        private Long currentId = 1L;

        public ProductService() {
            productRepo.put(1L, new Product(1L, "Laptop Pro", 1500.0));
            productRepo.put(2L, new Product(2L, "Smartphone X", 800.0));
            productRepo.put(3L, new Product(3L, "Tablet Z", 300.0));
            currentId = 4L;
        }
        public List<Product> getAllProducts() {
            return new ArrayList<>(productRepo.values());
        }
        public Optional<Product> getProductById(Long id) {
            return Optional.ofNullable(productRepo.get(id));
        }
        public Product createProduct(Product product) {
            product.setId(currentId++);
            productRepo.put(product.getId(), product);
            return product;
        }
        public Optional<Product> updateProduct(Long Id, Product product) {
            if (productRepo.containsKey(Id)) {
                product.setId(Id);
                productRepo.put(product.getId(), product);
                return Optional.of(product);
            }
            return Optional.empty();
        }
        public boolean deleteProduct(Long Id) {
            return productRepo.remove(Id) != null;
        }
    }}
