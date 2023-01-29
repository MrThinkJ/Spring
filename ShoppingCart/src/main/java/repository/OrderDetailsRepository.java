<<<<<<< HEAD
package repository;

import entity.OrderDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer> {
    @Query(value = "select * from orderdetails where order_id = ?1", nativeQuery = true)
    List<OrderDetails> findByOrderId(int orderId);
}
=======
package repository;

import entity.OrderDetails;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer> {
}
>>>>>>> b0da8640a166fc3ea30658d2af083bb238490599
