package ua.nure.koshova.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "\"ORDER\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "id_user",
            nullable = false
    )
    private User user;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name="product_order",
            joinColumns = { @JoinColumn(name = "id_order") },
            inverseJoinColumns = { @JoinColumn(name = "id_product") }
    )
    private Set<Product> products;

    @Column(name = "destination")
    private String destination;

    @Column(name = "datetime")
    private Timestamp datetime;

    public Order(Long id,
                 User user,
                 Set<Product> products,
                 String destination,
                 Timestamp datetime) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.destination = destination;
        this.datetime = datetime;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}
