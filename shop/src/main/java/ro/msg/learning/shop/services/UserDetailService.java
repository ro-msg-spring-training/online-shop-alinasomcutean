package ro.msg.learning.shop.services;

import ro.msg.learning.shop.model.Customer;

import java.util.List;

public interface UserDetailService {

    Customer retrieveUsernamePassword(Integer id);

    List<Customer> findAllCustomers();
}
