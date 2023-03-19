package softgen.shoptask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softgen.shoptask.entities.EntityWithStringId;

public interface EntityWithStringIdRepository extends JpaRepository <EntityWithStringId, String > {
}
