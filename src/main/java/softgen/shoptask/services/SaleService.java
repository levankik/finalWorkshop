package softgen.shoptask.services;

import org.springframework.stereotype.Service;
import softgen.shoptask.entities.Sale;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface SaleService {
    List<Sale> getSalesByDate(LocalDateTime sellDate);
}
