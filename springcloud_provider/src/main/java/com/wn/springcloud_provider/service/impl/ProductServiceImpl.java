package com.wn.springcloud_provider.service.impl;

import com.wn.springcloud_api.entity.Product;
import com.wn.springcloud_provider.dao.ProductDao;
import com.wn.springcloud_provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("productServices")
public class ProductServiceImpl implements ProductService {

    @Resource(name = "productDao")
    private ProductDao dao;

    @Override
    public List<Product> getAll() {
        return dao.getAll();
    }

    @Override
    public Product getid(Integer pid) {
        return dao.getid(pid);
    }

   /* @Override
    public Product getinter(Product product) {
        return dao.getinter(product);
    }*/
}
