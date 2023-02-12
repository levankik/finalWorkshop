package softgen.shoptask.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import softgen.shoptask.entities.Product;
import softgen.shoptask.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public List<Product> getProducts() { return productService.getProducts();}

    @GetMapping("/{id}")
    public Product  getProduct(@PathVariable int id)  {
        return productService.getProductById(id);
    }
    @PostMapping("")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}