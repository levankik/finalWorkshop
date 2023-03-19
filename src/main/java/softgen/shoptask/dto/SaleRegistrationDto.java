package softgen.shoptask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softgen.shoptask.entities.Product;
import softgen.shoptask.entities.Role;
import softgen.shoptask.entities.User;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleRegistrationDto {
    @NotNull
    private Double salePrice;
    @NotNull
    private Integer saleQuantity;
    @NotNull
    private Product product;
    @NotNull
    private User user;
    @Setter
    @Getter
    private static class Product {
        @NotNull
        private String productName;
        @NotNull
        private String description;
        @NotNull
        private Integer makerId;
    }
    @Setter
    @Getter
    private static class User {
        private String userName;
    }
}
