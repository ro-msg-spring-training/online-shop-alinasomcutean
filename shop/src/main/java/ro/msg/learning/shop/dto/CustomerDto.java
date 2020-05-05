package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.msg.learning.shop.model.Customer;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerDto {

    private String username;
    private String password;

    public CustomerDto(Customer customer) {
        this.username = customer.getUsername();
        this.password = customer.getPassword();
    }
}
