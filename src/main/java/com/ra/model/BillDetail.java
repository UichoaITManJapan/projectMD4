package com.ra.model;

import javax.persistence.*;

@Entity
@Table(name = "BillDetail")
public class BillDetail {
    @Id
    @Column(name = "billDetail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billDelId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
    private Bill bill;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
    @Column(name = "product_price")
    private float proPrice;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "total_bd")
    private float total;
    public BillDetail() {
    }

    public BillDetail(int billDelId, Bill bill, Product product, float proPrice, int quantity, float total) {
        this.billDelId = billDelId;
        this.bill = bill;
        this.product = product;
        this.proPrice = proPrice;
        this.quantity = quantity;
        this.total = total;
    }

    public int getBillDelId() {
        return billDelId;
    }

    public void setBillDelId(int billDelId) {
        this.billDelId = billDelId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getProPrice() {
        return proPrice;
    }

    public void setProPrice(float proPrice) {
        this.proPrice = proPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
