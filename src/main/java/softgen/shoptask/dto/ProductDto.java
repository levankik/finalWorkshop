package softgen.shoptask.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @NotNull
    private String productName;
    @NotNull
    private String description;
    @NotNull
    private Integer makerId;
    @NotNull
    private Integer categoryId;
    @NotNull
    private Double sellPrice;
    @NotNull
    private Integer addedProductAmount;
}