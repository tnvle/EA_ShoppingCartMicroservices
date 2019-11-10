package cs.mum.edu.catalogservice.services.impl;

import cs.mum.edu.catalogservice.entities.Product;
import cs.mum.edu.catalogservice.repositories.ProductRepository;
import cs.mum.edu.catalogservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
