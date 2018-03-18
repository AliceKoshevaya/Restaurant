package ua.nure.koshova.entity;


import java.sql.Timestamp;

public class Order {
    private Long id;
    private User user;
    private Basket basket;
    private String destination;
    private Timestamp datetime;

    public Order(Long id, User user, Basket basket, String destination, Timestamp datetime) {
        this.id = id;
        this.user = user;
        this.basket = basket;
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

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
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
