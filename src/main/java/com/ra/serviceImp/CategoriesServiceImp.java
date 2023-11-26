package com.ra.serviceImp;

import com.ra.model.Categories;
import com.ra.repository.CategoriesRepository;
import com.ra.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesServiceImp implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Override
    public List<Categories> displayData(String catalogName, int page, int size, String direction, String sortBy) {
        //Khởi tạo đối tượng Pageable
        Pageable pageable = PageRequest.of(page,size,
                direction.equals("ASC")? Sort.Direction.ASC: Sort.Direction.DESC,sortBy);
        List<Categories> categoriesList = categoriesRepository.findByCatalogName(catalogName,pageable).getContent();
        return categoriesList;
    }

    @Override
    public List<Integer> getListPage(String catalogName, int size) {
        int countCatalog = categoriesRepository.countByCatalogNameContains(catalogName);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < (int) Math.ceil((double) countCatalog / (double) size); i++) {
            listPage.add(i+1);
        }
        return listPage;
    }

    @Override
    public Categories findById(int catalogId) {
        return categoriesRepository.findById(catalogId).get();
    }

    @Override
    public Categories save(Categories categories) {
        return categoriesRepository.save(categories);
    }

    @Override
    public Categories update(Categories categories) {
        if (categoriesRepository.existsById(categories.getCatalogId())) {
            categoriesRepository.save(categories);
        }
        return categories;
    }

    @Override
    public boolean delete(int catalogId) {
        Categories categories = findById(catalogId);
        if (categories != null && categories.getListProduct().isEmpty()) {
            categoriesRepository.deleteById(catalogId);
            return true;
        } else {
            return false;
        }
    }
}
