package com.ra.repository;

import com.ra.model.Bill;
import com.ra.model.BillDetail;
import com.ra.model.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail,Integer> {
    @Query("select bd from BillDetail bd")
    List<BillDetail> findAll();
}
