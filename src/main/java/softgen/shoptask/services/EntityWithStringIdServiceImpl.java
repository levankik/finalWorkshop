package softgen.shoptask.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softgen.shoptask.configurations.SecUser;
import softgen.shoptask.entities.EntityWithStringId;
import softgen.shoptask.repositories.EntityWithStringIdRepository;

@Service
public class EntityWithStringIdServiceImpl implements EntityWithStringIdService {
    private final EntityWithStringIdRepository entityWithStringIdRepository;

    public EntityWithStringIdServiceImpl(EntityWithStringIdRepository entityWithStringIdRepository) {
        this.entityWithStringIdRepository = entityWithStringIdRepository;
    }

    @Override
    @Transactional
    public EntityWithStringId addEntityWithStringId(String name, SecUser user) {
        var EntityS = new EntityWithStringId();
        //foundEntityWithStringId.setId(null);
        EntityS.setProductName(name);

        return entityWithStringIdRepository.save(EntityS);
    }
}

