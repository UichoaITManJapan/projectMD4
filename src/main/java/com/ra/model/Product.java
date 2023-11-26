package com.ra.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private float price;
    @Column(name = "title")
    private String title;
    @Column(name = "describes")
    private String describe;
    @Column(name = "image")
    private String image;
    @Column(name = "units")
    private String units;
    @Column(name = "product_status")
    private boolean status;
    @OneToMany(mappedBy = "product")
    private List<Images> listImages;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catalog_id", referencedColumnName = "catalog_id")
    private Categories catalog;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "product")
    private List<BillDetail> detailList;

    public Product() {
    }

    public Product(int productId, String productName, float price, String title, String describe, String image, String units, boolean status, Categories catalog) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.describe = describe;
        this.image = image;
        this.units = units;
        this.status = status;
        this.catalog = catalog;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Categories getCatalog() {
        return catalog;
    }

    public void setCatalog(Categories catalog) {
        this.catalog = catalog;
    }

    public Product(List<Images> listImages) {
        this.listImages = listImages;
    }

    public List<Images> getListImages() {
        return listImages;
    }

    public void setListImages(List<Images> listImages) {
        this.listImages = listImages;
    }

    public List<BillDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<BillDetail> detailList) {
        this.detailList = detailList;
    }
}
