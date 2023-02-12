package softgen.shoptask.services;

import org.springframework.stereotype.Service;
import softgen.shoptask.entities.Sale;
import softgen.shoptask.repositories.SaleRepository;

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
        return saleRepository.findSalesBySellDate(sellDate);
    }

    @Override
    public Sale addSale(Sale sale) {
        return saleRepository.save(sale);
    }

}

