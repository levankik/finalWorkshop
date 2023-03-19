package softgen.shoptask.services;

import org.springframework.stereotype.Service;
import softgen.shoptask.configurations.SecUser;
import softgen.shoptask.entities.EntityWithStringId;

@Service
public interface EntityWithStringIdService {
     EntityWithStringId addEntityWithStringId(String name, SecUser user);
}

