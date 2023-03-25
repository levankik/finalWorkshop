package softgen.shoptask.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softgen.shoptask.configurations.SecUser;
import softgen.shoptask.entities.EntityWithStringId;
import softgen.shoptask.repositories.EntityWithStringIdRepository;

@RequiredArgsConstructor
@Service
public class EntityWithStringIdServiceImpl implements EntityWithStringIdService {
    private final EntityWithStringIdRepository entityWithStringIdRepository;

    @Override
    @Transactional
    public EntityWithStringId addEntityWithStringId(String name, SecUser user) {
        var EntityS = new EntityWithStringId();
        //foundEntityWithStringId.setId(null);
        EntityS.setProductName(name);

        return entityWithStringIdRepository.save(EntityS);
    }
}

