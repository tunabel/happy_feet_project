package c1812m.happyfeet.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "order_sku")
@Entity
public class OrderSku {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_sku_id")
    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sku_id")
    private Sku sku;

    @Column
    private int quantity;

    @Column
    private double price;
}
