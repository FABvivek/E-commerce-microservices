package com.ecommerce.product.Services;

import com.ecommerce.product.Modals.Product;
import com.ecommerce.product.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repo;

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> getAllProducts() {

        return repo.findAll();
    }

    public Product updateProduct(String id, Product updated) {

        Product product = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(updated.getName());
        product.setPrice(updated.getPrice());
        product.setStock(updated.getStock());
        product.setImageUrl(updated.getImageUrl());

        return repo.save(product);
    }

    public void deleteProduct(String id) {
        repo.deleteById(id);
    }
}
