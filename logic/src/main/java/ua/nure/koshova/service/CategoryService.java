package ua.nure.koshova.service;

import ua.nure.koshova.dao.jdbcTemplate.impl.CategoryDao;
import ua.nure.koshova.entity.Category;

//@Service
public class CategoryService {

//    @Autowired
    private CategoryDao categoryDao;

    private ua.nure.koshova.dao.hibernate.impl.CategoryDao hibernateCategoryDao;

    public int createCategory(Category category) {
        return categoryDao.insert(category);
    }

    public Category getCategory(Long id) {
//        return categoryDao.select(id);
        return hibernateCategoryDao.getCategory(id);
    }

    public boolean updateCategory(Category category) {
        return categoryDao.update(category);
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void setHibernateCategoryDao(ua.nure.koshova.dao.hibernate.impl.CategoryDao hibernateCategoryDao) {
        this.hibernateCategoryDao = hibernateCategoryDao;
    }
}

