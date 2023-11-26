package com.ra.service;

import com.ra.model.Accounts;
import com.ra.model.Categories;

import java.util.List;

public interface AccountsService {
    List<Accounts> displayData(String email, int page, int size, String direction, String sortBy);

    List<Integer> getListPage(String email, int size);
    void lockAccount(int accId);
    void unlockAccount(int accId);
    List<Accounts> getAllAccount();
}
