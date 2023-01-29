<<<<<<< HEAD
package repository;

import entity.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
    List<Orders> findAll();
    Orders findById(int id);
}
=======
package repository;

import entity.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer> {

}
>>>>>>> b0da8640a166fc3ea30658d2af083bb238490599
