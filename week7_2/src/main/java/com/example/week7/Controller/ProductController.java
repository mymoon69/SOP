package com.example.week7.Controller;

import com.example.week7.POJO.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ProductController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/addProduct", method = POST)
    public boolean addProduct(@RequestBody Product product){
        return (boolean) rabbitTemplate.convertSendAndReceive("ProductExchange", "add", product);
    }

    @RequestMapping(value = "/updateProduct", method = POST)
    public boolean updateProduct(@RequestBody Product product){
        return (boolean) rabbitTemplate.convertSendAndReceive("ProductExchange", "update", product);
    }

    @RequestMapping(value = {"/deleteProduct"}, method = {POST})
    public boolean deleteProduct(@RequestBody Product product){
        return (boolean) rabbitTemplate.convertSendAndReceive("ProductExchange", "delete", product);
    }

    @RequestMapping(value = {"/getProductByName/{name}"}, method = {GET})
    public Product getProductByName(@PathVariable String name){
        return (Product) rabbitTemplate.convertSendAndReceive("ProductExchange", "getname", name);
    }

    @RequestMapping(value = {"/getAllProduct"}, method = {GET})
    public List<Product> getAllProduct(){
        return (List<Product>) rabbitTemplate.convertSendAndReceive("ProductExchange", "getall", "");
    }
}
