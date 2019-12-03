package slabodchikov.tritpo.candy_shop.backend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "weight")
    private double weight;

    @Column(name = "price")
    private double price;

    @Column(name = "available_count")
    private long availableCount;

    @Column(name = "description")
    private String description;
}
