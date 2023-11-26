package com.ra.service;

import com.ra.model.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> displayData(String catalogName, int page, int size, String direction, String sortBy);

    List<Integer> getListPage(String catalogName, int size);

    Categories findById(int catalogId);

    Categories save(Categories categories);

    Categories update(Categories categories);

    boolean delete(int catalogId);
}
