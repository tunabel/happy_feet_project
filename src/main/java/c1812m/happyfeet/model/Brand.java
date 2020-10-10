package c1812m.happyfeet.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Brand {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brand_id")
    @Id
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private List<Product> productList = new ArrayList<>();

    @Column
    private String name;

    @Column
    private String desc;

    @Column(name = "create_date")
    private Date createDate;
}
