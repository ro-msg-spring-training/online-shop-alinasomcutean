package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDetailDTO {

    private LocationDTO location;

    private ProductDTO product;

    private Integer quantity;
}
