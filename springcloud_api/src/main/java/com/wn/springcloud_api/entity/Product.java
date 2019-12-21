package com.wn.springcloud_api.entity;

import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain=true)
public class Product implements Serializable {
    private Integer pid;

    private String productName;

    private Integer quantity;

    private String db_source;

    public String getDb_source() {
        return db_source;
    }

    public void setDb_source(String db_source) {
        this.db_source = db_source;
    }

    public Product(Integer pid, String productName, Integer quantity, String db_source) {
        this.pid = pid;
        this.productName = productName;
        this.quantity = quantity;
        this.db_source = db_source;
    }

    public Product() {
        super();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
