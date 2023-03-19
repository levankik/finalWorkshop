package softgen.shoptask.configurations;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import softgen.shoptask.entities.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class SecUser implements UserDetails {
    private String username;
    private String password;
    private Boolean enabled;
    private Integer id;
    private Collection<SimpleGrantedAuthority> authorities;

    public SecUser(User user) {
        this.username = user.getUserName();
        this.password = user.getPassword();
        this.enabled = user.getActive();
        this.id = user.getId();
        authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {

        return enabled;
    }

    public Integer getId() {
        return id;
    }
}