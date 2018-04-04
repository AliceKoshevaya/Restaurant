package ua.nure.koshova.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(
            name = "id_category",
            nullable = false
    )
    private Category category;

    @Column(name = "price")
    private Double price;

//    @ManyToMany(mappedBy = "products")
//    private Set<Order> orders = new HashSet<>();

//    public Product(Long id, String name, Double price, Category category, Set<Order> orders) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.category = category;
//        this.orders = orders;
//    }

    public Product() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade =  { CascadeType.ALL })
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

//    public Set<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Set<Order> orders) {
//        this.orders = orders;
//    }
}
