package ua.nure.koshova.dao.jdbcTemplate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.koshova.entity.Category;
import ua.nure.koshova.entity.Product;

//@Repository
public class ProductDao {

//    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${product.insert}")
    private String insertProductQuery;

    @Value("${product.select}")
    private String selectProductQuery;

    @Value("${product.update}")
    private String updateProductQuery;

    @Value("${product.delete}")
    private String deleteProductQuery;

    @Transactional
    public int insert(Product entity) {
        return jdbcTemplate.update(insertProductQuery,
                entity.getName(),
                entity.getCategory(),
                entity.getPrice()
        );
    }

    @Transactional(readOnly = true)
    public Product select(Long id) {
        return jdbcTemplate.queryForObject(
                selectProductQuery,
                new Object[]{id},
                (resultSet, i) -> {
                    Product product = new Product();
                    product.setId(resultSet.getLong(1));
                    product.setName(resultSet.getString(2));
                    product.setPrice(resultSet.getDouble(4));

                    Category category = new Category();
                    category.setId(resultSet.getLong(3));
                    category.setName(resultSet.getString(5));

                    product.setCategory(category);

                    return product;
                }
        );
    }

    @Transactional
    public boolean update(Product entity) {
        try {
            jdbcTemplate.update(
                    updateProductQuery,
                    entity.getName(),
                    entity.getCategory().getId(),
                    entity.getPrice(),
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
        jdbcTemplate.update(
                deleteProductQuery,
                id
        );
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

