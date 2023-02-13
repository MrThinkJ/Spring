package com.repository;

import com.entity.OrderDetails;
import com.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer> {
    List<OrderDetails> findAll();
    List<OrderDetails> findByOrdersId(int orderId);
    List<OrderDetails> findByProductsId(int id);
}
