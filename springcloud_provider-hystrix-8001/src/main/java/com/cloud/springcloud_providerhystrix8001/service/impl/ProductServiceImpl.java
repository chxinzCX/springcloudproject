package com.cloud.springcloud_providerhystrix8001.service.impl;

import com.cloud.springcloud_providerhystrix8001.dao.ProductDao;
import com.cloud.springcloud_providerhystrix8001.service.ProductService;
import com.wn.springcloud_api.entity.Product;
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
