package repository;

import entity.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> {
    List<Orders> findAll();
    @Query(value = "select * from orders where month(orderDate) = month(curdate()) and year(orderDate) = year(curdate());", nativeQuery = true)
    List<Orders> findAllInCurrentMonth();
    @Query(value = "select * from orders o join orderdetails od on o.id = od.orderId group by o.id having sum(od.quantity*od.unitPrice)>1000", nativeQuery = true)
    List<Orders> findAllTotalAmount1000();
    @Query(value = "select * from orders o inner join orderdetails od on o.id = od.orderId where od.productName =  'Dragon'", nativeQuery = true)
    List<Orders> findByProductName();

}
