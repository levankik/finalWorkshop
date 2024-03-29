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
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdGenerator")
    private Integer id;
    @Column(name = "password")
    private String password;
    @Column(name = "user_name", nullable = false)
    private String userName;
    //@Column(name = "user_role", nullable = false)
    //private String userRole;
    @Column(name = "active")
    private Boolean active;

    @JsonIgnore
    @OneToMany(mappedBy = "user") //, fetch = FetchType.EAGER
    private List<Purchase> purchases;

    @JsonIgnore
    @OneToMany(mappedBy = "user") //, fetch = FetchType.EAGER
    private List<Sale> sales;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private  List<Role> roles;

    @PrePersist
    public void prePersist () {
        active = true;
    }
}
