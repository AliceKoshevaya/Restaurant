package ua.nure.koshova.dao.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.nure.koshova.entity.Category;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

//@Repository
public class CategoryDao {

//    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public Category getCategory(Long id) {
        Category category = null;
        Transaction transaction = null;

        try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Category> query = builder.createQuery(Category.class);
            Root<Category> root = query.from(Category.class);
            query.select(root).where(builder.equal(root.get("id"), id));
            Query<Category> q = session.createQuery(query);
            category = q.getSingleResult();

            transaction.commit();
        } catch (Exception e) {
            // todo logging
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return category;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
