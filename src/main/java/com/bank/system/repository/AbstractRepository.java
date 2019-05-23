package com.bank.system.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractRepository<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractRepository(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<T> getList(){
        return getSession().createCriteria(persistentClass).list();
    }

    @SuppressWarnings("unchecked")
    public List<T> getListByCustomer(PK id){
        return getSession().createCriteria(persistentClass).add(Restrictions.eq("customerId", id)).list();
    }

    @SuppressWarnings("unchecked")
    public T getById(PK id) {
        return (T) getSession().get(persistentClass, id);
    }

    public void save(T entity) {
        getSession().persist(entity);

    }

    public void update(T entity){
        getSession().update(entity);

    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

}