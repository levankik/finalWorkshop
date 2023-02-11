package softgen.shoptask.services;

import org.springframework.stereotype.Service;
import softgen.shoptask.ecxeptions.NotFoundException;
import softgen.shoptask.entities.Sale;
import softgen.shoptask.repositories.SaleRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService{
    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }


    @Override
    public List<Sale> getSalesByDate(LocalDateTime sellDate) {
        return saleRepository.findSalesByDate(sellDate);
    }

    @Override
    @Transactional  //  (propagation = Propagation.SUPPORTS)
    public Sale addSale(Sale sale) {
        return saleRepository.save(sale);
    }
}

