package softgen.shoptask.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softgen.shoptask.ecxeptions.NotFoundException;
import softgen.shoptask.entities.Product;
import softgen.shoptask.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow (() -> new NotFoundException("Product not found"));
    }

    @Override
    @Transactional
    public Product addProduct(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }
}
