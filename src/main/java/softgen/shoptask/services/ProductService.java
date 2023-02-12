package softgen.shoptask.services;

import org.springframework.stereotype.Service;
import softgen.shoptask.entities.Product;
import softgen.shoptask.entities.User;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getProducts();
    Product getProductById(int id);
    Product addProduct(Product product);
}