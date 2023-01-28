package repository;

import entity.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer> {

}
