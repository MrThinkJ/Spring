package com.repository;

import com.entity.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends CrudRepository<Products, Integer> {
    List<Products> findAll();
    List<Products> findByProName(String searchInput);
}
