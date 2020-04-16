package ro.msg.learning.shop.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Data
@Entity
public class Address implements IPrimaryKey{

    @Id
    private int id;

    private String country;

    private String city;

    private String county;

    private String streetAddress;
}
