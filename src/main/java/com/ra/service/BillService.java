package com.ra.service;

import com.ra.model.Bill;
import com.ra.model.Categories;
import com.ra.model.Product;

import java.util.List;

public interface BillService {
    List<Bill> displayData(String billName, int page, int size, String direction, String sortBy);

    List<Integer> getListPage(String billName, int size);
    List<Bill> getAllBill();
    void cancelledStatus(int billId,int status);
    Float getTotalRevenueByCurrentDate();
    Float getTotalRevenueByCurrentMonth();
    Float getTotalRevenueByCurrentYear();
}
