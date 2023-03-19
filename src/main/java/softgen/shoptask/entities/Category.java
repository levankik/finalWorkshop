package softgen.shoptask.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "categories")
@SequenceGenerator(name = "categoryIdGenerator", sequenceName = "category_id_seq", allocationSize = 1)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryIdGenerator")
    private Integer id;

    //@Column(name = "parent_id")
    //private Integer parentId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

}
