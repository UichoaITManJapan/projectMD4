package com.ra.controller;

import com.ra.model.Categories;
import com.ra.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categoriesController")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private static final int SIZE = 6;
    private static String catalogNameDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "catalogId";
    private static int pageDefault = 1;
    @GetMapping("/findCatalog")
    public ModelAndView displayCatalog(Optional<String> catalogName, Optional<Integer> page,
                                       Optional<String> direction, Optional<String> sortBy) {
        ModelAndView mav = new ModelAndView("categories");
        catalogNameDefault=catalogName.orElse(catalogNameDefault);
        directionDefault=direction.orElse(directionDefault);
        sortByDefault=sortBy.orElse(sortByDefault);
        pageDefault=page.orElse(pageDefault);
        //Lấy dữ liệu hiển thị
        List<Categories> categoriesList = categoriesService.displayData(catalogNameDefault,pageDefault-1,SIZE,
                directionDefault,sortByDefault);
        //Lấy ra danh sách các trang theo kết quả tìm kiếm
        List<Integer> listPages = categoriesService.getListPage(catalogNameDefault,SIZE);
        mav.addObject("categoriesList",categoriesList);
        mav.addObject("listPages",listPages);
        mav.addObject("catalogName",catalogNameDefault);
        mav.addObject("sortBy",sortByDefault);
        mav.addObject("direction",directionDefault);
        return mav;
    }

    @GetMapping(value = "/initCreate")
    public String initCreateCatalog(ModelMap modelMap){
        Categories catalogNew = new Categories();
        modelMap.addAttribute("catalogNew",catalogNew);
        return "categoriesNew";
    }
    @PostMapping("/create")
    public String createCatalog(Categories catalogNew) {
        Categories categories = categoriesService.save(catalogNew);
        if (categories != null) {
            return "redirect:findCatalog";
        } else {
            return "error";
        }
    }
    @GetMapping("/initUpdate")
    public String editCategories(ModelMap modelMap,int catalogId) {
        Categories categoriesEdit = categoriesService.findById(catalogId);
        modelMap.addAttribute("categoriesEdit",categoriesEdit);
        return "categoriesUpdate";
    }
    @PostMapping("/update")
    public String updateCatalog(Categories categoriesEdit) {
        Categories categories = categoriesService.update(categoriesEdit);
        if (categories != null) {
            return "redirect:findCatalog";
        } else {
            return "error";
        }
    }

    @GetMapping("/delete")
    public String deleteCatalog(int catalogId) {

            boolean result = categoriesService.delete(catalogId);
            if (result) {
                return "redirect:findCatalog";
            } else {
                return "errorCategory";
            }
    }
}
