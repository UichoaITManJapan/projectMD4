package com.ra.serviceImp;

import com.ra.model.Accounts;
import com.ra.model.Categories;
import com.ra.repository.AccountsRepository;
import com.ra.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountsServiceImp implements AccountsService {
    @Autowired
    private AccountsRepository accountsRepository;
    @Override
    public List<Accounts> displayData(String email, int page, int size, String direction, String sortBy) {
        //Khởi tạo đối tượng Pageable
        Pageable pageable = PageRequest.of(page,size,
                direction.equals("ASC")? Sort.Direction.ASC: Sort.Direction.DESC,sortBy);
        List<Accounts> accountsList = accountsRepository.findByEmail(email,pageable).getContent();
        return accountsList;
    }

    @Override
    public List<Integer> getListPage(String email, int size) {
        int countAcc = accountsRepository.countByEmailContains(email);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < (int) Math.ceil((double) countAcc / (double) size); i++) {
            listPage.add(i+1);
        }
        return listPage;
    }

    @Override
    public void lockAccount(int accId) {
        Accounts accounts = accountsRepository.findById(accId).orElse(null);
        if (accounts != null) {
            accounts.setStatus(false);
            accountsRepository.save(accounts);
        }
    }

    @Override
    public void unlockAccount(int accId) {
        Accounts accounts = accountsRepository.findById(accId).orElse(null);
        if (accounts != null) {
            accounts.setStatus(true);
            accountsRepository.save(accounts);
        }
    }

    @Override
    public List<Accounts> getAllAccount() {
        return accountsRepository.findAll();
    }
}
