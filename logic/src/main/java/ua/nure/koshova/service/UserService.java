package ua.nure.koshova.service;

import ua.nure.koshova.dao.jdbcTemplate.impl.UserDao;
import ua.nure.koshova.entity.Order;
import ua.nure.koshova.entity.User;

import java.util.List;

//@Service
public class UserService {

//    @Autowired
    private UserDao userDao;

    private ua.nure.koshova.dao.hibernate.impl.UserDao hibernateUserDao;

    public int create(User user) {
        return userDao.insert(user);
    }

    public User readProfile(Long id) {
        return userDao.select(id);
    }

    public User readAll(Long id) {
        return userDao.select_all(id);
    }

    public List<Order> readOrdersByUser(Long userId) {
        return userDao.getUserOrders(userId);
    }

    public boolean updateUser(User user) {
        return userDao.update(user);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setHibernateUserDao(ua.nure.koshova.dao.hibernate.impl.UserDao hibernateUserDao) {
        this.hibernateUserDao = hibernateUserDao;
    }
}
