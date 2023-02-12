package softgen.shoptask.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "purchases")
@SequenceGenerator(name = "purchaseIdGenerator", sequenceName = "purchase_id_seq", allocationSize = 1)
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchaseIdGenerator")
    @Column(name = "id")
    private Integer id;
    @Column(name = "purchase_price", nullable = false)
    private Double purchasePrice;
    @Column(name = "purchase_date", nullable = false)
    private LocalDateTime purchaseDate;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
