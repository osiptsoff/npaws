package ru.osiptsoff.npaws.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.service.exception.MissingEntityException;
import ru.osiptsoff.npaws.util.UuidUtil;

@Transactional
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractCrudService<T> implements CrudService<T> {
    @Getter
    private final CrudRepository<T, UUID> repository;

    @Override
    public Dto<T> save(Dto<T> dto) throws DuplicateKeyException, DataIntegrityViolationException {
        if(dto.getId() != null) {
            throw new DuplicateKeyException(
                "Id must not be assigned"
            );
        }
        dto.setId(UuidUtil.generateUuid());
        T domainObj = dto.getEntity();

        return Dto.instantiate(getDtoClass(), upsert(domainObj));
    }

    @Override
    public Dto<T> update(Dto<T> dto) throws MissingEntityException, DataIntegrityViolationException {
        T domainObj = dto.getEntity();

        if(dto.getId() == null || !getRepository().existsById(dto.getId())) {
            throw new MissingEntityException(domainObj.getClass().getSimpleName() + " not found");
        }

        return dto.fillByEntity(upsert(domainObj));
    }

    @Override
    public void deleteById(UUID id) throws MissingEntityException {
        if(id == null || !getRepository().existsById(id)) {
            throw new MissingEntityException("Entity not found");
        }

        getRepository().deleteById(id);
    }

    @Override
    public Dto<T> findById(UUID id) throws MissingEntityException {
        if(id == null) {
            throw new MissingEntityException("Entity not found");
        }

        var result = Dto.instantiate(getDtoClass());
        
        Optional<T> optional = getRepository().findById(id);
        if(!optional.isPresent()) {
            throw new MissingEntityException("Entity not found");
        }

        return result.fillByEntity(optional.get());
    }

    protected T upsert(T obj) {
        return getRepository().save(obj);
    }

    abstract Class<? extends Dto<T>> getDtoClass();
}
