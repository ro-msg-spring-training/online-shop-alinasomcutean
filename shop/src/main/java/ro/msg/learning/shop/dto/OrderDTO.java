package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {

    private Integer id;

    private Date createdAt;

    private String country;

    private String city;

    private String county;

    private String streetAddress;

    private HashMap<Integer, Integer> orderedProducts;
}
