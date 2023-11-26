package com.ra.controller;

import com.ra.model.Categories;
import com.ra.model.Images;
import com.ra.model.Product;
import com.ra.service.CategoriesService;
import com.ra.service.ImagesService;
import com.ra.service.ProductService;
import com.ra.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private ImagesService imagesService;

    private static final int SIZE = 6;
    private static String catalogNameDefault = "";
    private static String keywordDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByProductDefault = "productId";
    private static String sortByCatalogId = "catalogId";
    private static int pageDefault = 1;

    @GetMapping("/findProduct")
    public ModelAndView displayProduct(
            Optional<String> productName,
            Optional<Integer> page,
            Optional<String> direction,
            Optional<String> sortBy) {
        ModelAndView mav = new ModelAndView("products");
        keywordDefault = productName.orElse(keywordDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByProductDefault = sortBy.orElse(sortByProductDefault);
        pageDefault = page.orElse(pageDefault);

        List<Product> listProducts = productService.displayData(
                keywordDefault, pageDefault - 1, SIZE, directionDefault, sortByProductDefault);
        List<Integer> listPages = productService.getListPage(keywordDefault, SIZE);

        mav.addObject("listProducts", listProducts);
        mav.addObject("listPages", listPages);
        mav.addObject("productName", keywordDefault);
        mav.addObject("sortBy", sortByProductDefault);
        mav.addObject("direction", directionDefault);

        return mav;
    }

    @GetMapping("/initCreate")
    public String initCreate(ModelMap modelMap) {
        Product productNew = new Product();
        List<Categories> categoriesList = categoriesService.displayData(catalogNameDefault, pageDefault-1, SIZE, directionDefault, sortByCatalogId);
        modelMap.addAttribute("productNew", productNew);
        modelMap.addAttribute("categoriesList", categoriesList);
        return "productNew";
    }

    @PostMapping(value = "/create")
    public String createProduct(Product productNew, MultipartFile productImage, MultipartFile[] otherImages) {
            String urlImage = uploadFileService.uploadFile(productImage);
            productNew.setImage(urlImage);
            Product proNew = productService.save(productNew);
            if (proNew != null) {
                //Thuc hien them moi cac anh phu cua san pham
                Arrays.asList(otherImages).forEach(image -> {
                    String imageLink = uploadFileService.uploadFile(image);
                    Images images = new Images();
                    images.setProduct(proNew);
                    images.setImageUrl(imageLink);
                    //Them moi vao model Images
                    boolean result = imagesService.save(images);
                });
                return "redirect:findProduct";
            } else {
                return "error";
            }
    }

    @GetMapping("/initUpdate")
    public String editProduct(ModelMap modelMap,int productId) {
        Product productEdit = productService.findById(productId);
        List<Categories> categoriesList = categoriesService.displayData(catalogNameDefault, pageDefault-1, SIZE, directionDefault, sortByCatalogId);
        modelMap.addAttribute("productEdit",productEdit);
        modelMap.addAttribute("categoriesList",categoriesList);
        return "productUpdate";
    }
    @PostMapping("/update")
    public String updateProduct(Product productEdit, MultipartFile productImage, MultipartFile[] otherImages) {
        String urlImage = uploadFileService.uploadFile(productImage);
        productEdit.setImage(urlImage);
        Product product = productService.update(productEdit);
        if (product != null) {
            if (otherImages != null) {
                //Thuc hien them moi cac anh phu cua san pham
                Arrays.asList(otherImages).forEach(image -> {
                    String imageLink = uploadFileService.uploadFile(image);
                    Images images = new Images();
                    images.setProduct(productEdit);
                    images.setImageUrl(imageLink);
                    //Them moi vao model Images
                    boolean result = imagesService.save(images);
                });
            }
                return "redirect:findProduct";
        } else {
            return "error";
        }
    }
    @GetMapping("/delete")
    public String deleteProduct(int productId) {
        boolean result = productService.delete(productId);
        if (result) {
            return "redirect:findProduct";
        } else {
            return "errorProduct";
        }
    }
}