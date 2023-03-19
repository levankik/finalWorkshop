package softgen.shoptask.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import softgen.shoptask.entities.Sale;
import softgen.shoptask.services.SaleService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
@PreAuthorize("hasRole('CASHIER')")
public class SaleController {
    public final SaleService saleService;
    @GetMapping("")
    public List<Sale> getSalesByDate( @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate sellDate) {
        return saleService.getSalesByDate(sellDate);
    }
}
