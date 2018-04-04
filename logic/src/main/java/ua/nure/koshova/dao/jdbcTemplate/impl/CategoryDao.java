package ua.nure.koshova.dao.jdbcTemplate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.koshova.entity.Category;

//@Repository
public class CategoryDao {

//    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${category.insert}")
    private String insertCategoryQuery;

    @Value("${category.select}")
    private String selectCategoryQuery;

    @Value("${category.update}")
    private String updateCategoryQuery;

    @Transactional
    public int insert(Category entity) {
        return jdbcTemplate.update(insertCategoryQuery, entity.getName());
    }

    @Transactional(readOnly = true)
    public Category select(Long id) {
        return jdbcTemplate.queryForObject(
                selectCategoryQuery,
                new Object[]{id},
                new BeanPropertyRowMapper<>(Category.class)
        );
    }

    @Transactional
    public boolean update(Category entity) {
        try {
            jdbcTemplate.update(
                    updateCategoryQuery,
                    entity.getName(),
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
        throw new UnsupportedOperationException("Can't delete category");
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}


