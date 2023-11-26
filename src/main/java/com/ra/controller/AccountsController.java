package com.ra.controller;

import com.ra.model.Accounts;
import com.ra.model.Categories;
import com.ra.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/accountsController")
public class AccountsController {
    @Autowired
    private AccountsService accountsService;
    private static final int SIZE = 6;
    private static String emailDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "accId";
    private static int pageDefault = 1;
    @GetMapping("/findAccounts")
    public ModelAndView displayAccounts(Optional<String> email, Optional<Integer> page,
                                       Optional<String> direction, Optional<String> sortBy) {
        ModelAndView mav = new ModelAndView("accounts");
        emailDefault=email.orElse(emailDefault);
        directionDefault=direction.orElse(directionDefault);
        sortByDefault=sortBy.orElse(sortByDefault);
        pageDefault=page.orElse(pageDefault);
        //Lấy dữ liệu hiển thị
        List<Accounts> accountsList = accountsService.displayData(emailDefault,pageDefault-1,SIZE,
                directionDefault,sortByDefault);

        //Lấy ra danh sách các trang theo kết quả tìm kiếm
        List<Integer> listPages = accountsService.getListPage(emailDefault,SIZE);
        mav.addObject("accountsList",accountsList);
        mav.addObject("listPages",listPages);
        mav.addObject("email",emailDefault);
        mav.addObject("sortBy",sortByDefault);
        mav.addObject("direction",directionDefault);
        return mav;
    }
    /**
     * sử lý lock và unlock khi tài khoản là khách hàng
     * */
    @GetMapping("/lockAccount")
    public String lockAccount(@RequestParam int accId) {
        accountsService.lockAccount(accId);
            return "redirect:/accountsController/findAccounts";
    }
    @GetMapping("/unlockAccount")
    public String unlockAccount(@RequestParam int accId) {
        accountsService.unlockAccount(accId);
        return "redirect:/accountsController/findAccounts";
    }

}
