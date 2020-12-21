package com.example.contactlist.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageableDto<T> {
    private List<T> dataList;
    private int currentPage;
    private Long totalItems;
    private int totalPages;
}
