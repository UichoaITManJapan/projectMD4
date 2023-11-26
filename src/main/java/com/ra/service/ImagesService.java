package com.ra.service;

import com.ra.model.Images;

import java.util.List;

public interface ImagesService {
    boolean save(Images images);
    List<Images> displayData();
}
