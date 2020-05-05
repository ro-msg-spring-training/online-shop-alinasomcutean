package ro.msg.learning.shop.dto;

import lombok.*;

import java.util.Date;
import java.util.HashMap;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

    private Integer id;

    private Date createdAt;

    private String country;

    private String city;

    private String county;

    private String streetAddress;

    private HashMap<Integer, Integer> orderedProducts;
}
