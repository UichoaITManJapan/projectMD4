package com.ra.controller;

import com.ra.model.BillDetail;
import com.ra.model.Images;
import com.ra.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/imageController")
public class ImageController {
    @Autowired
    private ImagesService imagesService;
@GetMapping("/findImage")
    public ModelAndView displayImage() {
        ModelAndView mav = new ModelAndView("image");
        List<Images> imagesList = imagesService.displayData();
        mav.addObject("imagesList", imagesList);
        return mav;
    }
}
