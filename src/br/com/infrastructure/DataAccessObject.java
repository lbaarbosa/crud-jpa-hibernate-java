package br.com.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DataAccessObject<E> {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private Class<E> eClass;

    static {
        try {
            entityManagerFactory = Persistence
                    .createEntityManagerFactory("crud-jpa-hibernate - java");
        } catch (Exception ex) {
        }
    }

    public DataAccessObject() {
        this(null);
    }

    public DataAccessObject(Class<E> eClass) {
        this.eClass = eClass;
        entityManager = entityManagerFactory.createEntityManager();
    }

    public DataAccessObject<E> beginTransaction() {
        entityManager.getTransaction().begin();
        return this;
    }

    public DataAccessObject<E> commitTransaction() {
        entityManager.getTransaction().commit();
        return this;
    }

    public DataAccessObject<E> insert(E entity) {
        entityManager.persist(entity);
        return this;
    }

    public DataAccessObject<E> atomicInsert(E entity) {
        return this
                .beginTransaction()
                .insert(entity)
                .commitTransaction();
    }

    public E getEntityByID(Object id) {
        return entityManager.find(eClass, id);
    }

    public List<E> getEntities(int limit, int offset) {
        if (eClass == null) {
            throw new UnsupportedOperationException("The class is null!");
        }
        String jpql = "SELECT e FROM " + eClass.getName() + " e";
        TypedQuery<E> typedQuery = entityManager.createQuery(jpql, eClass);
        typedQuery.setMaxResults(limit);
        typedQuery.setFirstResult(offset);
        return typedQuery.getResultList();
    }

    public List<E> getAllEntities() {
        return this.getEntities(10, 0);
    }

    public void close() {
        entityManager.close();
    }

}