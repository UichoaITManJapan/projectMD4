package com.ra.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categories")
public class Categories {
    @Id
    @Column(name = "catalog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catalogId;
    @Column(name = "catalog_name")
    private String catalogName;
    @Column(name = "catalog_describe")
    private String CatalogDescribe;
    @Column(name = "catalog_status")
    private boolean status;
    @OneToMany(mappedBy = "catalog",fetch = FetchType.EAGER)
    private List<Product> listProduct;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String catalogDescribe, boolean status, List<Product> listProduct) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        CatalogDescribe = catalogDescribe;
        this.status = status;
        this.listProduct = listProduct;
    }
//
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogDescribe() {
        return CatalogDescribe;
    }

    public void setCatalogDescribe(String catalogDescribe) {
        CatalogDescribe = catalogDescribe;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }
}
