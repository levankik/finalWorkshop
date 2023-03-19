package softgen.shoptask.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import softgen.shoptask.configurations.SecUser;
import softgen.shoptask.entities.Product;
import softgen.shoptask.entities.Purchase;
import softgen.shoptask.entities.Sale;
import softgen.shoptask.services.ProductService;
import softgen.shoptask.services.PurchaseService;
import softgen.shoptask.services.SaleService;
import java.util.List;

@Tag(name = "Product", description = "Product API")
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@PreAuthorize("hasRole('CASHIER')")
public class ProductController {
    private final ProductService productService;
    private final SaleService saleService;
    private final PurchaseService purchaseService;

    @GetMapping("")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id)
    {
        return productService.getProductById(id);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping("")
    @Transactional
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        var location = UriComponentsBuilder.fromPath("/products/" + product.getId()).build().toUri();
        System.out.println(location);
        return ResponseEntity.created(location).body(product);
    }

    @PostMapping("/{id}/sale")
    public Sale addSale(@PathVariable int id, @RequestParam int saleQuantity, @AuthenticationPrincipal SecUser user) {
        return saleService.addSale(id, saleQuantity, user);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping("/{id}/purchase")
    public Purchase addPurchase(@PathVariable int id, @RequestParam int purchaseQuantity,
                                @RequestParam double purchasePrice, @AuthenticationPrincipal SecUser user) {
        return purchaseService.addPurchase(id, purchaseQuantity,  purchasePrice,  user);
    }

}