package cs.mum.edu.catalogservice.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false)
    private String name;
    private double price;

    private String vendor;
    private String category;
//    @Transient
    @Column(name = "quantityinstock")
    private int quantityInStock;
}
