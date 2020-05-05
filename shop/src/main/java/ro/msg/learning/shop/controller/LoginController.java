package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.CustomerDto;
import ro.msg.learning.shop.model.Customer;
import ro.msg.learning.shop.services.UserDetailService;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final UserDetailService userDetailService;

    @GetMapping(value = "/login/{id}")
    public CustomerDto getCustomer(@PathVariable int id) {
        Customer customer = userDetailService.retrieveUsernamePassword(id);
        return new CustomerDto(customer);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<Object> login() {
        return new ResponseEntity<>("Successfully logged in", HttpStatus.OK);
    }

    @RequestMapping(value = "/logout")
    public ResponseEntity<Object> logout() {
        return new ResponseEntity<>("Successfully logged out", HttpStatus.OK);
    }
}
