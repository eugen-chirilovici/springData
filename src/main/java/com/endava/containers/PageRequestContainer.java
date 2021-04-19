package com.endava.containers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Sort;

@Getter
@AllArgsConstructor
public class PageRequestContainer {
    private int pageNumber;
    private int pageSize;
    private Sort sort;
}
