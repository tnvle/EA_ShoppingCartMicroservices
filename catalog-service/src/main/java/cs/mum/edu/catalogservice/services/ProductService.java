package cs.mum.edu.catalogservice.services;

import cs.mum.edu.catalogservice.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> findById(Long id);
}
