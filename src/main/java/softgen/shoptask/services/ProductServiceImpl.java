package softgen.shoptask.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softgen.shoptask.dto.ProductDto;
import softgen.shoptask.ecxeptions.InvalidParameterException;
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
        if (id < 1) {
            throw new InvalidParameterException("Id has to be a positive integer");
        }
        return productRepository.findById(id)
                .orElseThrow (() -> new NotFoundException("Product not found"));
    }

    @Override
    @Transactional
    public Product addProduct(ProductDto productDto) {
        Product newProduct = new Product();
        newProduct.setId(null);
        newProduct.setRemaining(0);
        Product product = productRepository.
                findFirstByProductNameAndDescription(productDto.getProductName(),productDto.getDescription());
        if (productRepository.findFirstByProductName(productDto.getProductName()) == null ||
                productRepository.findFirstByDescription(productDto.getDescription()) == null)
        {
            return getProductFromDTO(productDto, newProduct);
        } else {
            return getProductFromDTO(productDto, product);
        }
    }

    private Product getProductFromDTO(ProductDto productDto, Product product) {
        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setMakerId(productDto.getMakerId());
        product.setCategoryId(productDto.getCategoryId());
        product.setSellPrice(productDto.getSellPrice());
        product.setRemaining(product.getRemaining() + productDto.getAddedProductAmount());
        return productRepository.save(product);
    }
}
