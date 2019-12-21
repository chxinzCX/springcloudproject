package com.cloud.springcloud_providerhystrix8001.controller;


import com.cloud.springcloud_providerhystrix8001.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.wn.springcloud_api.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource(name = "productServices")
    private ProductService service;

    @Autowired
    private DiscoveryClient client;

    //查询全部
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getAll() {
        List<Product> all = service.getAll();
        for (Product product:all){
            System.out.println(product.getProductName());
        }
        return all;
    }

    @RequestMapping(value = "/getid/{pid}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getid_ex")
    @ResponseBody
    public Product getid(@PathVariable("pid") Integer pid){
        Product getid = service.getid(pid);
        if(null == getid)
        {
            throw new RuntimeException("该ID："+pid+"没有没有对应的信息");
        }

        return getid;
    }

    public Product getid_ex(@PathVariable("pid") Integer pid){
         Product p=new Product();
         p.setPid(1);
         p.setProductName("该ID："+pid+"没有没有对应的信息,null--@HystrixCommand");
         p.setDb_source("no this database in MySQL");
        return p;
    }

    @RequestMapping(value = "/getname",method = RequestMethod.GET)
    @ResponseBody
    public Object discovery(){
        List<String> list=client.getServices();
        System.out.println("*********************"+list);
        List<ServiceInstance> srvList=client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element:srvList){
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }
       return this.client;
    }


   /* @RequestMapping"/getinter")
    @ResponseBody
    public Product getinter(Product product){
        Product getinter = service.getinter(product);
        return  getinter;
    }*/


}
