package c1812m.happyfeet.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Sku> skuList = new ArrayList<>();

    private String name;

    @Column
    private String desc;

    private double price;

    @Column(name = "create_date")
    private Date createDate;

}
