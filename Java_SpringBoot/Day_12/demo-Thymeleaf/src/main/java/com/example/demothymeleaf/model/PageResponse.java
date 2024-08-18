package com.example.demothymeleaf.model;

import java.util.List;

public interface PageResponse<T> {
    int getCurrenPage();

    int getPageSize();

    int totalElements();

    int totalPages();

    List<T> getContent();

}
