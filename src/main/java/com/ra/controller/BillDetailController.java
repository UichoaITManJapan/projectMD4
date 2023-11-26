package com.ra.controller;

import com.ra.model.Bill;
import com.ra.model.BillDetail;
import com.ra.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/billDelController")
public class BillDetailController {
    @Autowired
    private BillDetailService billDetailService;
    @GetMapping("/findBillDel")
    public ModelAndView displayBillDel() {
        ModelAndView mav = new ModelAndView("billDetail");
        List<BillDetail> billDetailList = billDetailService.displayData();
        mav.addObject("billDetailList", billDetailList);
        return mav;
    }
}
