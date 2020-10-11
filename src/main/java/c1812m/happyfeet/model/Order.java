package c1812m.happyfeet.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Order {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    @Id
    private int id;

    @Column
    private String guid;

    @Column
    private String username;

    @Column(name = "customer_name")
    private String customerName;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private double price;

    @Column (name = "create_date")
    private Date createDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private final List<OrderSku> orderSkuList = new ArrayList<>();

    @Column
    private int status;
}
