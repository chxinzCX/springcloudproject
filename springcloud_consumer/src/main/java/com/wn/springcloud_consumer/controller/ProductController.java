package com.wn.springcloud_consumer.controller;

import com.wn.springcloud_api.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {

    //private static final String REST_URL_PREFIX="http://localhost:8001";
    private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    //查询全部
    @SuppressWarnings("unckecked")
    @RequestMapping("/controller/product/getAll")
    //@ResponseBody
    public List<Product> getAll(){
        System.out.println("--------------------");
        return restTemplate.getForObject(REST_URL_PREFIX+"/product/getAll",List.class);
    }

    //根据id查询列表
    @RequestMapping("/controller/product/getid/{pid}")
    public Product getid(@PathVariable("pid") Integer pid){
        return restTemplate.getForObject(REST_URL_PREFIX+"/product/getid/"+pid,Product.class);
    }

    //测试@EnableDiscoveryClient，消费可以调用服务发现
    @RequestMapping("/controller/product/getname")
    public Object getname(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/product/getname",Object.class);
    }

}
