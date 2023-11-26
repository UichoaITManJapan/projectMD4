package com.ra.serviceImp;

import com.ra.model.Images;
import com.ra.repository.ImagesRepository;
import com.ra.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesServiceImp implements ImagesService {
    @Autowired
    private ImagesRepository imagesRepository;
    @Override
    public boolean save(Images images) {
        try {
            imagesRepository.save(images);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Images> displayData() {
        return imagesRepository.findAll();
    }
}
