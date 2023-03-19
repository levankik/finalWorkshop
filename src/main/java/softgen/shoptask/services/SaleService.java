package softgen.shoptask.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softgen.shoptask.configurations.SecUser;
import softgen.shoptask.entities.Product;
import softgen.shoptask.entities.Sale;

import java.time.LocalDate;
import java.util.List;

@Service
public interface SaleService {
    List<Sale> getSalesByDate(LocalDate saleDate);

    @Transactional
    Sale addSale(int productId, int saleQuantity, SecUser user);
}
