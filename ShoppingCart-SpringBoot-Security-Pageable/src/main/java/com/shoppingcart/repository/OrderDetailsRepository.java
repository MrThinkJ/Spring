package com.shoppingcart.repository;

import com.shoppingcart.entity.OrderDetails;
import com.shoppingcart.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface OrderDetailsRepository extends PagingAndSortingRepository<OrderDetails, Integer> {
    List<OrderDetails> findAll();
    Page<OrderDetails> findAllByOrders(Orders orders, Pageable pageable);
//    Page<OrderDetails> findByQuantity(int quantity, Pageable pageable);
}
