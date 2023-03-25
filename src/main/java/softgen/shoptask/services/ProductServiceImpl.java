package softgen.shoptask.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softgen.shoptask.ecxeptions.NotFoundException;
import softgen.shoptask.entities.Product;
import softgen.shoptask.repositories.ProductRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

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
