package softgen.shoptask.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import softgen.shoptask.entities.Sale;
import softgen.shoptask.services.SaleService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
//@PreAuthorize("hasAuthority('USER_READ')")
public class SaleController {
    public final SaleService saleService;
    @GetMapping("")
    public List<Sale> getSalesByDate(@RequestParam  LocalDateTime sellDate) {
        return saleService.getSalesByDate(sellDate);
    }

}
