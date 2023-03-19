package softgen.shoptask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softgen.shoptask.entities.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>  {
}
