package com.ra.repository;

import com.ra.model.Bill;
import com.ra.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer> {
    @Query("select b from Bill b where b.billName like %?1%")
    Page<Bill> findByBillName(String BillName, Pageable pageable);
    int countByBillNameContains(String billName);
    @Override
    List<Bill> findAll();

    // Tổng doanh thu theo ngày
    @Query("SELECT SUM(bd.total) FROM BillDetail bd WHERE bd.bill.created = :currentDate")
    Float getTotalRevenueByCurrentDate(@Param("currentDate") Date currentDate);

    // Tổng doanh thu theo tháng
    @Query("SELECT SUM(bd.total) FROM BillDetail bd WHERE FUNCTION('MONTH', bd.bill.created) = FUNCTION('MONTH', CURRENT_DATE)")
    Float getTotalRevenueByCurrentMonth();

    // Tổng doanh thu theo năm
    @Query("SELECT SUM(bd.total) FROM BillDetail bd WHERE FUNCTION('YEAR', bd.bill.created) = FUNCTION('YEAR', CURRENT_DATE)")
    Float getTotalRevenueByCurrentYear();
}
