package ua.nure.koshova.dao.jdbcTemplate.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.koshova.entity.Category;
import ua.nure.koshova.entity.Order;
import ua.nure.koshova.entity.Product;
import ua.nure.koshova.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

//@Repository
public class OrderDao {

//    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${order.insert}")
    private String insertOrderQuery;

    @Value("${order.select}")
    private String selectOrderQuery;

    @Value("${order.update}")
    private String updateOrderQuery;
    private ProductDao productDao;
    private UserDao userDao;

    @Transactional
    public int insert(Order entity) {
        return jdbcTemplate.update(insertOrderQuery,
                entity.getUser().getId(),
                entity.getDestination(),
                entity.getDatetime()
        );
    }

    @Transactional(readOnly = true)
    public Order select(Long id) {
        return jdbcTemplate.queryForObject(
                selectOrderQuery,
                new Object[]{id},
                (resultSet, i) -> {
                    Order order = new Order();
                    order.setId(resultSet.getLong(1));
                    order.setDatetime(resultSet.getTimestamp(2));
                    order.setDestination(resultSet.getString(3));

                    User user = new User();
                    user.setTelephone(resultSet.getString(4));
                    user.setFirstName(resultSet.getString(5));
                    user.setLastName(resultSet.getString(6));
                    order.setUser(user);

                    Set<Product> products = new HashSet<>();
                    do {
                        Product product = new Product();
                        configureProduct(resultSet, product);
                        products.add(product);
                    } while (resultSet.next());
                    order.setProducts(products);

                    return order;
                }
        );
    }

    private void configureProduct(ResultSet resultSet, Product product) throws SQLException {
        product.setName(resultSet.getString(7));
        product.setPrice(resultSet.getDouble(8));

        Category category = new Category();
        category.setName(resultSet.getString(9));

        product.setCategory(category);
    }

    @Transactional
    public boolean update(Order entity) {
        try {
            jdbcTemplate.update(
                    updateOrderQuery,
                    entity.getDatetime(),
                    entity.getDestination(),
                    entity.getId());
        } catch (DataAccessException e) {
            // todo logging
            return false;
        }
        return true;
    }

    @Transactional
    public void delete(Long id) {
        throw new UnsupportedOperationException("Order can't be deleted");
    }

    public void setProductDao(ProductDao ProductDao) {
        productDao = ProductDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setUserDao(UserDao UserDao) {
        userDao = UserDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

