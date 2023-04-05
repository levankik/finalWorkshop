package softgen.shoptask.services;
import softgen.shoptask.dto.ProductDto;
import softgen.shoptask.entities.Product;
import java.util.List;


public interface ProductService {
    List<Product> getProducts();
    Product getProductById(int id);
    Product addProduct(ProductDto productDto);
}