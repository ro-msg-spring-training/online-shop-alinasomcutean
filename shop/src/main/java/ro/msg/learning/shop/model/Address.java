package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "address", schema = "shop_schema")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String country;

    private String city;

    private String county;

    private String streetAddress;

    public Address(String country, String county, String city, String streetAddress) {
        this.country = country;
        this.county = county;
        this.city = city;
        this.streetAddress = streetAddress;
    }
}
