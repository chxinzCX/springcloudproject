package com.wn.springcloud_provider02.dao;

import com.wn.springcloud_api.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public interface ProductDao {

    //查询全部
    public List<Product> getAll();

    //根据id查询列表
    public Product getid(@Param("pid") Integer pid);

 /*   //新增
    public Product getinter(Product product);*/


}
