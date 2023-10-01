package com.example.week7.Service;

import com.example.week7.POJO.Product;
import com.example.week7.Repositury.ProductRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public ProductService (ProductRepository repository) {
        this.repository = repository;
    }

    @CacheEvict(value = "Product", allEntries = true)
    @RabbitListener(queues = "AddProductQueue")
    public boolean addProduct(Product product){
        try {
            this.repository.save(product);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @CachePut(value = "Product")
    @RabbitListener(queues = "UpdateProductQueue")
    public boolean updateProduct(Product product){
        try {
            this.repository.save(product);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @CacheEvict(value = "Product", allEntries = true)
    @RabbitListener(queues = "DeleteProductQueue")
    public boolean deleteProduct(Product product){
        try {
            this.repository.delete(product);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Cacheable(value = "Product")
    @RabbitListener(queues = "GetAllProductQueue")
    public List<Product> getAllProduct(){
        try {
            return repository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

//    @Cacheable(value = "Product")
    @RabbitListener(queues = "GetNameProductQueue")
    public Product getProductByName(String productName){
        return repository.findByName(productName);
    }
}
