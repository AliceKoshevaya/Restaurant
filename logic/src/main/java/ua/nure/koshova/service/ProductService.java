package ua.nure.koshova.service;

import ua.nure.koshova.dao.jdbcTemplate.impl.ProductDao;
import ua.nure.koshova.entity.Product;

//@Service
public class ProductService {

//    @Autowired
    private ProductDao productDao;

    public int create(Product product) {
        return productDao.insert(product);
    }

    public Product getProduct(Long id) {
        return productDao.select(id);
    }

    public boolean updateProduct(Product product) {
        return productDao.update(product);
    }

    public void deleteProduct(Long prodId) {
        productDao.delete(prodId);
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}

