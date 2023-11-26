package com.ra.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Accounts")
public class Accounts {
    @Id
    @Column(name = "acc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accId;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @Column(name = "permission")
    private boolean permission;
    @Column(name = "acc_status")
    private boolean status;
//    @OneToMany(mappedBy = "accounts",fetch = FetchType.EAGER)
//    private List<Bill> billList;


    public Accounts() {
    }

    public Accounts(int accId, String email, String password, Date created, boolean permission, boolean status) {
        this.accId = accId;
        this.email = email;
        this.password = password;
        this.created = created;
        this.permission = permission;
        this.status = status;
//        this.billList = billList;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


//    public List<Bill> getBillList() {
//        return billList;
//    }
//
//    public void setBillList(List<Bill> billList) {
//        this.billList = billList;
//    }
}
