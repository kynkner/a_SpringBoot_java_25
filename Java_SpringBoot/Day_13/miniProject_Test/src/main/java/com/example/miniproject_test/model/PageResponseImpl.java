package com.example.miniproject_test.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponseImpl<T> implements PageResponse<T>{
    int currentPage;
    int pageSize;
    List<T> data;


    @Override
    public int getCurrenPage() {
        return currentPage;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public int totalElements() {
        return data.size();
    }

    @Override
    public int totalPages() {
        return (int) Math.ceil((double) data.size() /pageSize);
    }

    @Override
    public List<T> getContent() {
        int fromIndex = (currentPage - 1) * pageSize;
        if (fromIndex >= data.size()) {
            return List.of();
        }
        int toIndex = Math.min(fromIndex + pageSize, data.size());
        return data.subList(fromIndex, toIndex);
    }
}
