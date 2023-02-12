package softgen.shoptask.services;

import org.springframework.stereotype.Service;
import softgen.shoptask.entities.Sale;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface SaleService {
    List<Sale> getSalesByDate(LocalDateTime sellDate);

    Sale addSale(Sale sale);
}
