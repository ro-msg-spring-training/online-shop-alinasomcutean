package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "revenue", schema = "shop_schema")
public class Revenue implements IPrimaryKey{

    @Id
    private int id;

    @ManyToOne
    private Location location;

    private Date date;

    private double sum;
}
