package softgen.shoptask.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softgen.shoptask.configurations.SecUser;
import softgen.shoptask.ecxeptions.NotFoundException;
import softgen.shoptask.entities.Sale;
import softgen.shoptask.repositories.SaleRepository;
import softgen.shoptask.repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class SaleServiceImpl implements SaleService{
    private final SaleRepository saleRepository;
    private final UserRepository userRepository;
    private final ProductService productService;


    @Override
    public List<Sale> getSalesByDate(LocalDate saleDate) {
        return saleRepository.findSalesBySaleDate(saleDate);
    }

    @Override
    @Transactional
    public Sale addSale(int productId, int saleQuantity, SecUser user) {
        var sale = new Sale();
        sale.setId(null);
        var foundProduct = productService.getProductById(productId);
        var productRemaining = foundProduct.getRemaining();
        if (productRemaining >= saleQuantity) {
            productRemaining = productRemaining - saleQuantity;
            foundProduct.setRemaining(productRemaining);
        }  else {
            throw new NotFoundException("Sufficient product not found");
        }
        sale.setProduct(foundProduct);        
        sale.setSaleQuantity(saleQuantity);
        sale.setSalePrice(foundProduct.getSellPrice() * saleQuantity);

        var foundUser = userRepository.findByUserName(user.getUsername())
                .orElseThrow(() -> new NotFoundException("User not found"));
        sale.setUser(foundUser);
        return saleRepository.save(sale);
    }

}

