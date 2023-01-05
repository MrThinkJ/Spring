package main;

import config.Config;
import entity.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.CustomerRepository;
import service.CustomerService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Customer> initListCustomer(){
        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setName("Thinh");
        customer1.setAddress("Da Nang");
        customer1.setBirthday(LocalDate.parse("2003-10-08"));
        customer1.setSex("male");
        customer1.setPhone("0777777777");
        customer1.setEmail("binthinhle@gmail.com");
        Customer customer2 = new Customer();
        customer2.setName("Le");
        customer2.setAddress("Quang Nam");
        customer2.setBirthday(LocalDate.parse("1998-10-08"));
        customer2.setSex("male");
        customer2.setPhone("0777777777");
        customer2.setEmail("binthinhle@gmail.com");
        Customer customer3 = new Customer();
        customer3.setName("Thinh");
        customer3.setAddress("Da Nang");
        customer3.setBirthday(LocalDate.parse("1999-10-08"));
        customer3.setSex("female");
        customer3.setPhone("0777777777");
        customer3.setEmail("binthinhle@gmail.com");
        Customer customer4 = new Customer();
        customer4.setName("Thinh");
        customer4.setAddress("Da Nang");
        customer4.setBirthday(LocalDate.parse("1995-10-08"));
        customer4.setSex("male");
        customer4.setPhone("0777777777");
        customer4.setEmail("binthinhle@gmail.com");
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        return  customerList;
    }
    public static void main(String[] args) {
//  Add Customer
//        List<Customer> customerList = initListCustomer();
//        CustomerService.addCustomer(customerList.get(0));
//        CustomerService.addCustomer(customerList.get(1));
//        CustomerService.addCustomer(customerList.get(2));
//        CustomerService.addCustomer(customerList.get(3));
//  Show All Customer
//        CustomerService.showAllCustomer();
//  Find By Id
//        CustomerService.findById(2);
//  Find By Name
//        CustomerService.findByName("thi");
//  Find By Phone Or Email
//        CustomerService.findByPhoneOrEmail("0777777777", "binthinhle@gmail.com")
//  List All Customer Who Are Men And Years Old from 20 to 30
//        CustomerService.findMenYearFrom20to30();
    }
}
