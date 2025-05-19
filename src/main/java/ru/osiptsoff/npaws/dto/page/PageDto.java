package ru.osiptsoff.npaws.dto.page;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.osiptsoff.npaws.dto.Dto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDto<T> {
    protected List<? extends Dto<T>> data;
    protected Integer pageNumber;
    protected Integer totalPages;
}
