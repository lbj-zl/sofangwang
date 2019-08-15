package com.imooc.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ServiceMultiResult<T> {
    private int total;

    private List<T> result;

    public int getResultSize() {
        if (result == null) {
            return 0;
        }
        return result.size();
    }
}
