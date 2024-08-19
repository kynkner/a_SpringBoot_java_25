package com.example.miniproject_test.model;

import java.util.List;

public interface PageResponse<T> {
    int getCurrenPage();

    int getPageSize();

    int totalElements();

    int totalPages();

    List<T> getContent();
}
