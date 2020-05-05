package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exceptions.CustomerNotFoundException;
import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.repository.CustomerRepo;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailService{

    private final CustomerRepo customerRepo;

    @Override
    public Customer retrieveUsernamePassword(Integer id) {
        return customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with id" + id + "doesn't exist"));
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }
}
