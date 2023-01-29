<<<<<<< HEAD
package service;

import configuration.JPAConfig;
import entity.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");

    public static List<Product> productList(){
        return productRepository.findAll();
    }

    public static Product findById(int id){
        return productRepository.findById(id).get();
    }
}
=======
package service;

import configuration.JPAConfig;
import entity.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");

    public static List<Product> productList(){
        return productRepository.findAll();
    }

    public static Product findById(int id){
        return productRepository.findById(id).get();
    }
}
>>>>>>> b0da8640a166fc3ea30658d2af083bb238490599
