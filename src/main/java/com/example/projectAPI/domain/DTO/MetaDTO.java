package com.example.projectAPI.domain.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetaDTO {
    private int page;
    private int pageSize;
    private int pages;
    private int totalPages;
}
