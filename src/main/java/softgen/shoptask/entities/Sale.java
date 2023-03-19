package softgen.shoptask.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "sales")
@SequenceGenerator(name = "saleIdGenerator", sequenceName = "sales_id_seq", allocationSize = 1)
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saleIdGenerator")
    private Integer id;
    @Column(name = "sale_price", nullable = false)
    private Double salePrice;

    @Column(name = "sale_date", nullable = false, updatable = false)
    private LocalDate saleDate;

    @Column(name = "sale_quantity", nullable = false)
    private Integer saleQuantity;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @PrePersist
    public void prePersist () {
        saleDate = LocalDate.now();
    }
}
