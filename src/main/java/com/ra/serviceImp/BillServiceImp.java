package com.ra.serviceImp;

import com.ra.model.Bill;
import com.ra.model.Categories;
import com.ra.repository.BillRepository;
import com.ra.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BillServiceImp implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Override
    public List<Bill> displayData(String billName, int page, int size, String direction, String sortBy) {
        //Khởi tạo đối tượng Pageable
        Pageable pageable = PageRequest.of(page,size,
                direction.equals("ASC")? Sort.Direction.ASC: Sort.Direction.DESC,sortBy);
        List<Bill> billList = billRepository.findByBillName(billName,pageable).getContent();
        return billList;
    }

    @Override
    public List<Integer> getListPage(String billName, int size) {
        int countBill = billRepository.countByBillNameContains(billName);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < (int) Math.ceil((double) countBill / (double) size); i++) {
            listPage.add(i+1);
        }
        return listPage;
    }

    @Override
    public List<Bill> getAllBill() {
        return billRepository.findAll();
    }

    @Override
    public void cancelledStatus(int billId, int status) {
        Bill bill = billRepository.findById(billId).orElse(null);
        if (bill != null) {
            bill.setStatus(status);
            billRepository.save(bill);
        }
    }

    @Override
    public Float getTotalRevenueByCurrentDate() {
        return billRepository.getTotalRevenueByCurrentDate(new Date());
    }

    @Override
    public Float getTotalRevenueByCurrentMonth() {
        return billRepository.getTotalRevenueByCurrentMonth();
    }

    @Override
    public Float getTotalRevenueByCurrentYear() {
        return billRepository.getTotalRevenueByCurrentYear();
    }
}
