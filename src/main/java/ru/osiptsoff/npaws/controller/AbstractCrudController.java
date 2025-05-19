package ru.osiptsoff.npaws.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.service.CrudService;

@RequiredArgsConstructor
public abstract class AbstractCrudController<T, U extends Dto<T>> {
    @Getter
    private final CrudService<T> service;

    @PostMapping("")
    public Dto<T> create(@Valid @RequestBody U dto) {
        return getService().save(dto);
    }

    @GetMapping("/{id}")
    public Dto<T> read(@PathVariable UUID id) {
        return getService().findById(id);
    }

    @PutMapping("/{id}")
    public Dto<T> update(@Valid @RequestBody U dto,
            @PathVariable UUID id) {
        dto.setId(id);

        return getService().update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        getService().deleteById(id);
    }
}
