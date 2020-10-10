package c1812m.happyfeet.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Sku {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sku_id")
    @Id
    private int id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sku")
    private List<OrderSku> orderSkuList = new ArrayList<>();

    private int size;

    @Column(name = "create_date")
    private Date createDate;
}
