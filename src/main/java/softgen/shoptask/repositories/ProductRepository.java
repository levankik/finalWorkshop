package softgen.shoptask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softgen.shoptask.entities.Product;

import javax.validation.constraints.NotNull;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findFirstByProductName(String productName);
    Object findFirstByDescription(String description);
    Product findFirstByProductNameAndDescription(String productName, String description);
}

