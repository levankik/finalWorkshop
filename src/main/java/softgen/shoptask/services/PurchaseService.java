package softgen.shoptask.services;
import softgen.shoptask.configurations.SecUser;
import softgen.shoptask.entities.Purchase;


public interface PurchaseService {
    Purchase addPurchase(int productId, int purchaseQuantity, double purchasePrice, SecUser user);
}
