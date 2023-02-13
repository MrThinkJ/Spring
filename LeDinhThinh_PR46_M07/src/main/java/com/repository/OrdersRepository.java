package com.repository;

import com.entity.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> {
    List<Orders> findAll();
    Orders findById(int id);
    List<Orders> findByCustomerNameContainingOrOrderDateIsBetween(String customerName, LocalDate orderDate1, LocalDate orderDate2);
    @Query(value = "select o.orderId from orderdetails as od join orders as o on o.orderId = od.orderId join products as p on p.proId = od.proId where p.proName like ?1",nativeQuery = true)
    List<Integer> findByOrderId(String searchInput);
}