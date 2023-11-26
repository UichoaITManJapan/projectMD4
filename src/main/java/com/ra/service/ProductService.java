package com.ra.service;

import com.ra.model.Accounts;
import com.ra.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> displayData(String productName, int page, int size, String direction, String sortBy);

    List<Integer> getListPage(String productName, int size);

    Product findById(int productId);

    Product save(Product product);

    Product update(Product product);

    boolean delete(int productId);
    List<Product> getAllProduct();
}
