package ua.nure.koshova.dao;

public interface GenericCRUD<T> {
    void insert(T entity);
    T select(Long id);
    T update(T entity);
    void delete(Long id);
}
