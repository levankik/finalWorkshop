package softgen.shoptask.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
@SequenceGenerator(name = "userIdGenerator", sequenceName = "user_id_seq", allocationSize = 1)
public class User {
    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdGenerator")
    @Column(name = "id")
    private Integer id;
    @Column(name = "password")
    private String password;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "user_role", nullable = false)
    private String userRole;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Purchase> purchases;
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Sale> sales;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_permissions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private  List<Permission> permissions;
}
