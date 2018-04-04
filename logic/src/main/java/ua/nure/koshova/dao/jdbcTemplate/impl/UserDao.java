package ua.nure.koshova.dao.jdbcTemplate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.koshova.entity.Order;
import ua.nure.koshova.entity.User;

import java.util.List;

//@Repository
public class UserDao {

//    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${user.insert}")
    private String insertUserQuery;

    @Value("${user.select}")
    private String selectUserQuery;

    @Value("${user.select_profile}")
    private String selectUserProfileQuery;

    @Value("${user.select_orders}")
    private String selectUserOrdersQuery;

    @Value("${user.update}")
    private String updateUserQuery;

    @Transactional
    public int insert(User entity) {
        return jdbcTemplate.update(insertUserQuery,
                entity.getTelephone(),
                entity.getPassword(),
                entity.getFirstName(),
                entity.getLastName()
        );
    }

    @Transactional(readOnly = true)
    public User select_all(Long id) {
        return jdbcTemplate.queryForObject(
                selectUserProfileQuery,
                new Object[]{id},
                new BeanPropertyRowMapper<>(User.class)
        );
    }

    @Transactional(readOnly = true)
    public User select(Long id) {
        return jdbcTemplate.queryForObject(
                selectUserQuery,
                new Object[]{id},
                (resultSet, i) -> {
                    User user = new User();
                    user.setId(resultSet.getLong(1));
                    user.setTelephone(resultSet.getString(2));
                    user.setFirstName(resultSet.getString(3));
                    user.setLastName(resultSet.getString(4));
                    return user;
                }
        );
    }

    @Transactional(readOnly = true)
    public List<Order> getUserOrders(Long userId) {
        return jdbcTemplate.query(
                selectUserOrdersQuery,
                new Object[]{userId},
                (resultSet, i) -> {
                    User user = new User();
                    user.setId(resultSet.getLong(1));
                    user.setTelephone(resultSet.getString(2));
                    user.setFirstName(resultSet.getString(3));
                    user.setLastName(resultSet.getString(4));

                    Order order = new Order();
                    order.setId(resultSet.getLong(5));
                    order.setUser(user);

                    return order;
                }
        );
    }

    @Transactional
    public boolean update(User entity) {
        try {
            jdbcTemplate.update(
                    updateUserQuery,
                    entity.getTelephone(),
                    entity.getPassword(),
                    entity.getFirstName(),
                    entity.getLastName(),
                    entity.getId()
            );
        } catch (DataAccessException e) {
            // todo logging
            return false;
        }
        return true;
    }

    @Transactional
    public void delete(Long id) {
        throw new UnsupportedOperationException("User can't be deleted");
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
