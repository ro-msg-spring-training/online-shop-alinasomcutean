package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.msg.learning.shop.model.Location;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LocationDTO {

    private Integer id;

    private String name;

    private String country;

    private String city;

    private String county;

    private String streetAddress;

    public LocationDTO(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.country = location.getAddress().getCountry();
        this.county = location.getAddress().getCounty();
        this.city = location.getAddress().getCity();
        this.streetAddress = location.getAddress().getStreetAddress();
    }
}
