package ua.nure.koshova.entity;

import java.util.List;

public class Basket {
    private List<Order> orders;

    public Basket(List<Order> orders) {
        this.orders = orders;
    }

    public Basket() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
