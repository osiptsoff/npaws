package ru.osiptsoff.npaws.service;

import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.service.exception.MissingEntityException;

public interface CrudService<T> {
    Dto<T> save(Dto<T> dto) throws DuplicateKeyException, DataIntegrityViolationException;
    Dto<T> update(Dto<T> dto) throws MissingEntityException, DataIntegrityViolationException;
    void deleteById(UUID id) throws MissingEntityException;
    Dto<T> findById(UUID id) throws MissingEntityException;
}
