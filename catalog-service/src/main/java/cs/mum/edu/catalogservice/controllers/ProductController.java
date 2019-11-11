package cs.mum.edu.catalogservice.controllers;

import cs.mum.edu.catalogservice.entities.Product;
import cs.mum.edu.catalogservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{productId}/checkValid/{quantity}")
    @ResponseBody
    public Integer checkValid(@PathVariable(name="productId") Long productId, @PathVariable(name="quantity") int quantity) {

        Optional<Product> product = productService.findById(productId);
        //check if product exists or not
        if(!product.isPresent())
            return -1;
        //check if order quantity > stock quantity
        if(quantity > product.get().getQuantityInStock())
            return -2;
        return 1;//success
    }
}
