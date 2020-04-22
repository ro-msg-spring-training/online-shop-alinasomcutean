package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "address", schema = "shop_schema")
public class Address implements IPrimaryKey{

    @Id
    private int id;

    private String country;

    private String city;

    private String county;

    private String streetAddress;
}
