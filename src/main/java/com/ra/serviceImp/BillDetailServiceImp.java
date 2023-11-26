package com.ra.serviceImp;

import com.ra.model.Bill;
import com.ra.model.BillDetail;
import com.ra.repository.BillDetailRepository;
import com.ra.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillDetailServiceImp implements BillDetailService {
    @Autowired
    private BillDetailRepository billDetailRepository;
    @Override
    public List<BillDetail> displayData() {
        List<BillDetail> billDetailList = billDetailRepository.findAll();
        return billDetailList;
    }

}
