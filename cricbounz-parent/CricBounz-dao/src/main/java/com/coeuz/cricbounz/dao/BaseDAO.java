package com.coeuz.cricbounz.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.coeuz.cricbounz.dao.IBaseDAO;

/**
 * Base class for all hibernate DAO implementations
 * extend this class only when your require custom CRUD logic.
 *
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 */
@SuppressWarnings("unchecked")
public class BaseDAO<T, PK extends Serializable> implements IBaseDAO<T, PK> {

    /**
     * Log variable for all child classes.
     */
    private final Class<T> persistentClass;


    private SessionFactory sessionFactory;
    
    private Session session;

    /**
     * Constructor that takes in a class to see which type of entity to persist.
     * Use this constructor when subclassing.
     *
     * @param persistentClass the class type you'd like to persist
     */
    public BaseDAO(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    /**
     * Constructor that takes in a class and sessionFactory for easy creation of DAO.
     *
     * @param persistentClass the class type you'd like to persist
     * @param sessionFactory  the pre-configured Hibernate SessionFactory
     */
    public BaseDAO(final Class<T> persistentClass, SessionFactory sessionFactory) {
        this.persistentClass = persistentClass;
        this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**0.
     * {@inheritDoc}
     */
    public List<T> getAll() {
        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(this.persistentClass);
        List<T> list = criteria.list();
        session.close();
        return list;
    }
    
    
    /**
     * {@inheritDoc}
     */
    /*
    public T get(long id) {
    	session = sessionFactory.openSession();
        T entity = (T) session.load(this.persistentClass, id);
        if (entity == null) {
            throw new ObjectRetrievalFailureException(this.persistentClass, id);
        }
        session.close();
        return entity;
    }
    */
    
    /**
     * {@inheritDoc}
     */
    public T get(long id) {
    	session = sessionFactory.openSession();
        T entity = (T) session.get(this.persistentClass, id);
        if (entity == null) {
            throw new ObjectRetrievalFailureException(this.persistentClass, id);
        }
        session.close();
        return entity;
    }

    

    /**
     * {@inheritDoc}
     */
    public boolean exists(long id) {
    	session = sessionFactory.openSession();
        T entity = (T) session.get(this.persistentClass, id);
        session.close();
        return entity != null;
    }

    /**
     * {@inheritDoc}
     */
    public T save(T object) {
    	session = sessionFactory.openSession();
        session.beginTransaction();
        T obj = (T) session.save(object);
       session.flush();
       session.getTransaction().commit();
       session.close();
        return obj; 
    }

    /**
     * {@inheritDoc}
     */
    public void saveorUpdate(T object) {
    	session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(object);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    /**
     * {@inheritDoc}
     */
    public void saveorUpdate(List<T> objectList) {
    	session = sessionFactory.openSession();
        session.beginTransaction();
        for(Object obj:objectList){
        	session.saveOrUpdate(obj);
        	session.flush();
            session.getTransaction().commit();
        }
        session.close();
    }
    
    public long saveAndRetrunUniqkey(T object) {
       session = sessionFactory.openSession();
       session.beginTransaction();
       Long obj = (Long) session.save(object);
       session.flush();
       session.getTransaction().commit();
       session.close();
       return obj; 
    }
    
    
    /**
     * {@inheritDoc}
     */
    public void delete(Long id) {
    	session = sessionFactory.openSession();
        session.beginTransaction();
        T entity = (T) session.get(this.persistentClass, id);
        session.delete(entity);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }


    public void update(T object) {
    	session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(object);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

   /* public List<T> findByQuery(String queryString, Map<String, Object> queryParams) {
        String[] params = new String[queryParams.size()];
        Object[] values = new Object[queryParams.size()];

        int index = 0;
        for (String s : queryParams.keySet()) {
            params[index] = s;
            values[index++] = queryParams.get(s);
        }
        session = sessionFactory.openSession();
       Query query = session.getNamedQuery(queryString);
        return (List<T>) hibernateTemplate.findByNamedParam(queryString, params, values);
    }*/
}