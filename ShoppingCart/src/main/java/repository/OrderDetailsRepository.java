package repository;

import entity.OrderDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer> {
    List<OrderDetails> findAll();
    @Query(value = "select * from orderdetails where order_id = ?1", nativeQuery = true)
    List<OrderDetails> findByOrderId(int orderId);

    @Query(value = "select * from orderdetails where order_id = ?1 limit ?2 offset ?3", nativeQuery = true)
    List<OrderDetails> findByOrderIdLimit(int orderId, int limit, int offset);
}
