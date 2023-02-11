package softgen.shoptask.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "maker_id", nullable = false)
    private Integer makerId;
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;
    @Column(name = "sell_price", nullable = false)
    private Double sellPrice;
    @Column(name = "remaining", nullable = false)
    private Integer remaining;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<Sale> sales;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<Purchase> purchase;

    @PrePersist
    private void ensureId(){
        this.setId(UUID.randomUUID().toString());
    }

}

