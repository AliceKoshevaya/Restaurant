package ua.nure.koshova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.nure.koshova.entity.Order;
import ua.nure.koshova.service.OrderService;

@RestController
public class OrderController {

//    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public int createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PutMapping("/orders")
    public boolean updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}

