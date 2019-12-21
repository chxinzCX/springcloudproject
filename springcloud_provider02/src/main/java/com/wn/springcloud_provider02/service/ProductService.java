package com.wn.springcloud_provider02.service;

import com.wn.springcloud_api.entity.Product;

import java.util.List;

public interface ProductService {

    //查询全部
    public List<Product> getAll();

    //根据id查询列表
    public Product getid(Integer pid);

  /*  //新增
    public Product getinter(Product product);*/


}
