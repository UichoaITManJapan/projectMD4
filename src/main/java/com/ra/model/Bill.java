package com.ra.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @Column(name = "bill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;
    @Column(name = "bill_name")
    private String billName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
    private Accounts accounts;
    @Column(name = "created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @Column(name = "bill_status")
    private int status;
    @OneToMany(mappedBy = "bill",fetch = FetchType.EAGER)
    private List<BillDetail> detailList;

    public Bill() {
    }

    public Bill(int billId, Accounts accounts, Date created, int status) {
        this.billId = billId;
        this.accounts = accounts;
        this.created = created;
        this.status = status;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Bill(String billName) {
        this.billName = billName;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }
}
