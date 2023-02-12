package softgen.shoptask.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "sales")
@SequenceGenerator(name = "saleIdGenerator", sequenceName = "sale_id_seq", allocationSize = 1)
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saleIdGenerator")
    @Column(name = "id")
    private Integer id;
    @Column(name = "sell_price", nullable = false)
    private String sellPrice;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "sell_date", nullable = false)
    private LocalDateTime sellDate;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
