package repository;

import entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByNameLike(String name);
    List<Customer> findByPhoneOrEmail(String phone, String email);
    @Query(value = "Select * from customer c where c.sex like 'male' and (year(curdate()) - year(c.birthday) >= 20 and year(curdate()) - year(c.birthday <=30))", nativeQuery = true)
    List<Customer> findMenYearFrom20to30();
}
