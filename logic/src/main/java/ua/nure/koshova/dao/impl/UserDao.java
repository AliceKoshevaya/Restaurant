package ua.nure.koshova.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.nure.koshova.dao.GenericCRUD;
import ua.nure.koshova.entity.User;


public class UserDao implements GenericCRUD<User> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("user.insert")
    private String insertUserQuery;

    @Value("user.select")
    private String selectUserQuery;

    @Override
    public void insert(User entity) {
        jdbcTemplate.update(insertUserQuery,
                entity.getId(),
                entity.getTelephone(),
                entity.getPassword(),
                entity.getFirstName(),
                entity.getLastName()
        );
    }

    @Override
    public User select(Long id) {
        return jdbcTemplate.queryForObject(selectUserQuery, User.class, id);
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
