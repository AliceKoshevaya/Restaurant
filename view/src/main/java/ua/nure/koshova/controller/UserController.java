package ua.nure.koshova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import ua.nure.koshova.entity.Order;
import ua.nure.koshova.entity.User;
import ua.nure.koshova.event.ControllerLoggingSpringEvent;
import ua.nure.koshova.service.UserService;

import java.util.List;

@RestController
public class UserController {

    private static final String LOG_POST = "Request on POST /users";
    private static final String LOG_GET = "Request on GET /users";
    private static final String LOG_PUT = "Request on PUT /users";

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

//    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public int createUser(@RequestBody User user) {
        ControllerLoggingSpringEvent clse = new ControllerLoggingSpringEvent(this, LOG_POST);
        applicationEventPublisher.publishEvent(clse);
        return userService.create(user);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        ControllerLoggingSpringEvent clse = new ControllerLoggingSpringEvent(this, LOG_GET);
        applicationEventPublisher.publishEvent(clse);
        return userService.readProfile(id);
    }

    @GetMapping("/users/{id}/orders")
    public List<Order> getUserOrders(@PathVariable Long id) {
        ControllerLoggingSpringEvent clse = new ControllerLoggingSpringEvent(this, LOG_GET);
        applicationEventPublisher.publishEvent(clse);
        return userService.readOrdersByUser(id);
    }

    @PutMapping("/users")
    public boolean updateUser(@RequestBody User user) {
        ControllerLoggingSpringEvent clse = new ControllerLoggingSpringEvent(this, LOG_PUT);
        applicationEventPublisher.publishEvent(clse);
        return userService.updateUser(user);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
