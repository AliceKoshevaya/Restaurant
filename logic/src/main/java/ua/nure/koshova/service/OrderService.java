package ua.nure.koshova.service;

import ua.nure.koshova.dao.jdbcTemplate.impl.OrderDao;
import ua.nure.koshova.entity.Order;

//@Service
public class OrderService {

//    @Autowired
    private OrderDao orderDao;

    public int createOrder(Order order) {
        return orderDao.insert(order);
    }

    public Order getOrder(Long id) {
        return orderDao.select(id);
    }

    public boolean updateOrder(Order order) {
        return orderDao.update(order);
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
