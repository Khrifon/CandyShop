package slabodchikov.tritpo.candy_shop.backend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shipment")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "count")
    private int count;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
