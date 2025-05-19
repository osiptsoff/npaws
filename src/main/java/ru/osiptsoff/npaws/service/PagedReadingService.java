package ru.osiptsoff.npaws.service;


import ru.osiptsoff.npaws.dto.page.PageDto;
import ru.osiptsoff.npaws.dto.page.PageRequestDto;

public interface PagedReadingService<T> {
    PageDto<T>findPage(PageRequestDto pageRequestDto);
}
