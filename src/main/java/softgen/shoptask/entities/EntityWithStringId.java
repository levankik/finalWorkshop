package softgen.shoptask.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "second_hand_products")
public class EntityWithStringId {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "name", nullable = false)
    private String productName;

    @PrePersist
    private void ensureId(){
        this.setId(UUID.randomUUID().toString());
        System.out.println(id);
    }

    //@PrePersist
    //public void prePersist () {
       // purchaseDate = LocalDate.now();
    //}
}
