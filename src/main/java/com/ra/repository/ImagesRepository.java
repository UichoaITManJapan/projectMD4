package com.ra.repository;

import com.ra.model.BillDetail;
import com.ra.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesRepository extends JpaRepository<Images,Integer> {
    @Query("select i from Images i")
    List<Images> findAll();
}
