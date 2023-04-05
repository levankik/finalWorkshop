package softgen.shoptask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softgen.shoptask.entities.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
