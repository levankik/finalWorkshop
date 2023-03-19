package softgen.shoptask.services;

import org.springframework.stereotype.Service;
import softgen.shoptask.configurations.SecUser;
import softgen.shoptask.entities.Purchase;

@Service
public interface PurchaseService {
    Purchase addPurchase(int productId, int purchaseQuantity, double purchasePrice, SecUser user);
}
