package cs.mum.edu.catalogservice.controllers;

import cs.mum.edu.catalogservice.entities.Product;
import cs.mum.edu.catalogservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    @ResponseBody
    public List<Product> allProducts(HttpServletRequest request) {
        return productService.getAllProducts();
    }
}
