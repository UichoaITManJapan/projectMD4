package com.ra.repository;

import com.ra.model.Accounts;
import com.ra.model.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Integer> {
    @Query("select a from Accounts a where a.email like %?1%")
    Page<Accounts> findByEmail(String email, Pageable pageable);
    int countByEmailContains(String email);

    @Override
     List<Accounts> findAll();
}
