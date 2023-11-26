package com.ra.controller;

import com.ra.model.Bill;
import com.ra.model.Product;
import com.ra.service.AccountsService;
import com.ra.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/billController")
public class BillController {
    @Autowired
    private BillService billService;
//    @Autowired
//    private AccountsService accountsService;
    private static final int SIZE = 6;
    private static String catalogNameDefault = "";
    private static String keywordDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByBillDefault = "billId";
//    private static String sortByAccId = "accId";
    private static int pageDefault = 1;
    @GetMapping("/findBill")
    public ModelAndView displayBill(
            Optional<String> billName,
            Optional<Integer> page,
            Optional<String> direction,
            Optional<String> sortBy) {
        ModelAndView mav = new ModelAndView("bill");
        keywordDefault = billName.orElse(keywordDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByBillDefault = sortBy.orElse(sortByBillDefault);
        pageDefault = page.orElse(pageDefault);

        List<Bill> billList = billService.displayData(
                keywordDefault, pageDefault - 1, SIZE, directionDefault, sortByBillDefault);
        List<Integer> listPages = billService.getListPage(keywordDefault, SIZE);

        mav.addObject("billList", billList);
        mav.addObject("listPages", listPages);
        mav.addObject("billName", keywordDefault);
        mav.addObject("sortBy", sortByBillDefault);
        mav.addObject("direction", directionDefault);

        return mav;
    }
    @GetMapping("/cancelledBill")
    public String cancelledBill(@RequestParam int billId,@RequestParam int status) {
        billService.cancelledStatus(billId,status);
        return "redirect:/billController/findBill";
    }


}
