package ru.osiptsoff.npaws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Getter;
import ru.osiptsoff.npaws.dto.Dto;
import ru.osiptsoff.npaws.dto.page.PageDto;
import ru.osiptsoff.npaws.dto.page.PageRequestDto;
import ru.osiptsoff.npaws.service.CrudService;
import ru.osiptsoff.npaws.service.PagedReadingService;

public abstract class AbstractPagedCrudController<T, U extends Dto<T>> extends AbstractCrudController<T, U> {
    @Getter
    private final PagedReadingService<T> pService;

    protected AbstractPagedCrudController(CrudService<T> service, PagedReadingService<T> pService) {
        super(service);
        this.pService = pService;
    }

    @GetMapping("")
    public PageDto<T> read(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return getPService().findPage(new PageRequestDto(pageNumber, pageSize));
    }
}
