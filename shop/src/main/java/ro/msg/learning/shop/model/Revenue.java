package ro.msg.learning.shop.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@Builder
@Data
@Entity
public class Revenue implements IPrimaryKey{

    @Id
    private int id;

    @ManyToOne
    private Location location;

    private Date date;

    private double sum;
}
