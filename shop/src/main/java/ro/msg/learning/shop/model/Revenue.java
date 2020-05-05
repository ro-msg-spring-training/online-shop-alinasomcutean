package ro.msg.learning.shop.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "revenue", schema = "shop_schema")
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Location location;

    private Date date;

    private Double sum;
}
