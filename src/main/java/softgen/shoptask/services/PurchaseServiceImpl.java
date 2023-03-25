package softgen.shoptask.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softgen.shoptask.configurations.SecUser;
import softgen.shoptask.ecxeptions.NotFoundException;
import softgen.shoptask.entities.Purchase;
import softgen.shoptask.repositories.PurchaseRepository;
import softgen.shoptask.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final ProductService productService;

    @Override
    @Transactional
    public Purchase addPurchase(int productId, int purchaseQuantity, double purchasePrice, SecUser user) {
        var purchase = new Purchase();
        var foundProduct = productService.getProductById(productId);
        purchase.setId(null);
        purchase.setPurchaseQuantity(purchaseQuantity);
        foundProduct.setRemaining(foundProduct.getRemaining() + purchaseQuantity);
        purchase.setPurchasePrice(purchasePrice);
        purchase.setProduct(foundProduct);
        var foundUser = userRepository.findByUserName(user.getUsername()).
                orElseThrow(() -> new NotFoundException("User not found"));
        purchase.setUser(foundUser);
        return purchaseRepository.save(purchase);
    }
}
