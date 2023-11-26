package com.ra.controller;

import com.ra.model.Accounts;
import com.ra.model.Bill;
import com.ra.model.Product;
import com.ra.service.AccountsService;
import com.ra.service.BillService;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/staticController")
public class staticController {
    @Autowired
    private AccountsService accountsService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BillService billService;
    @GetMapping("/staticList")
    public ModelAndView staticList() {
        ModelAndView mav = new ModelAndView("static");
        List<Accounts> allAcc =  accountsService.getAllAccount();
        int cntAccActive = 0, cntAccInactive=0;
        for (Accounts accounts: allAcc) {
            if (accounts.isStatus()) {
                cntAccActive++;
            } else {
                cntAccInactive++;
            }
        }
        mav.addObject("totalAccounts", cntAccActive + cntAccInactive);
        mav.addObject("cntAccActive", cntAccActive);
        mav.addObject("cntAccInactive", cntAccInactive);

        List<Product> allProduct =  productService.getAllProduct();
        int cntProActive = 0, cntProInactive=0;
        for (Product product: allProduct) {
            if (product.isStatus()) {
                cntProActive++;
            } else {
                cntAccInactive++;
            }
        }
        mav.addObject("totalProduct", cntProActive + cntProInactive);
        mav.addObject("cntProActive", cntProActive);
        mav.addObject("cntProInactive", cntProInactive);

        List<Bill> allBill =  billService.getAllBill();
        int cntBill1 = 0, cntBill2=0,cntBill3 = 0, cntBill4 = 0, cntBill5 = 0;
        for (Bill bill: allBill) {
            if (bill.getStatus() ==1 ) {
                cntBill1++;
            } else if (bill.getStatus() == 2) {
                cntBill2++;
            } else if (bill.getStatus() == 3) {
                cntBill3++;
            } else if (bill.getStatus() == 4){
                cntBill4++;
            } else {
                cntBill5++;
            }
        }
        mav.addObject("totalBill", cntBill1 + cntBill2 + cntBill3 + cntBill4 + cntBill5);
        mav.addObject("cntBill1", cntBill1);
        mav.addObject("cntBill2", cntBill2);
        mav.addObject("cntBill3", cntBill3);
        mav.addObject("cntBill4", cntBill4);
        mav.addObject("cntBill5", cntBill5);

        mav.addObject("totalRevenueByCurrentDate",billService.getTotalRevenueByCurrentDate());
        mav.addObject("totalRevenueByCurrentMonth",billService.getTotalRevenueByCurrentMonth());
        mav.addObject("totalRevenueByCurrentYear",billService.getTotalRevenueByCurrentYear());

        return mav;
    }
}
