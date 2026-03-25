package com.ecommerce.product.Repository;

import com.ecommerce.product.Modals.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
