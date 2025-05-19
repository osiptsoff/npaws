package ru.osiptsoff.npaws.service;

import java.util.UUID;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import jakarta.transaction.Transactional;
import lombok.Getter;
import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.dto.page.PageDto;
import ru.osiptsoff.npaws.dto.page.PageRequestDto;

public abstract class AbstractPagingCrudService<T> extends AbstractCrudService<T> implements PagedReadingService<T> {
    @Getter
    private PagingAndSortingRepository<T, UUID> psRepository;

    protected AbstractPagingCrudService(CrudRepository<T, UUID> repository,
            PagingAndSortingRepository<T, UUID> psRepository) {
        super(repository);
        this.psRepository = psRepository;
    }

    @Override
    public PageDto<T> findPage(PageRequestDto pageRequestDto) {
        return findPage(pageRequestDto, p -> getPsRepository().findAll(p));
    }

    @Transactional
    protected PageDto<T> findPage(PageRequestDto pageRequestDto, Function<PageRequest, Page<T>> func) {
        Page<T> page;
        var pageRequest = PageRequest.of(pageRequestDto.getPageNumber(), pageRequestDto.getPageSize());

        page = func.apply(pageRequest);
        var result = page.map(o -> Dto.instantiate(getDtoClass(), o)).getContent();

        return new PageDto<>(result, page.getNumber(), page.getTotalPages());
    }
}
