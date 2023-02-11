package softgen.shoptask.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "makers")
@SequenceGenerator(name = "makerIdGenerator", sequenceName = "maker_id_seq", allocationSize = 1)
public class Maker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "makerIdGenerator")
    @Column(name = "id")
    private Integer id;
    @Column(name = "maker_name", nullable = false)
    private String makerName;
}
