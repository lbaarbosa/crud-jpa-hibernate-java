package br.com.test.basic;

import br.com.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class GetUsersList {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("crud-jpa-hibernate - java");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        String jpql = "SELECT u FROM User u";
//        TypedQuery<User> typedQuery = entityManager.createQuery(jpql, User.class);
//        typedQuery.setMaxResults(3);
//        List<User> usersList = typedQuery.getResultList();

        List<User> usersList = entityManager
                .createQuery("SELECT u FROM User u", User.class)
                .setMaxResults(3)
                .getResultList();

        for(User user : usersList) {
            System.out.println("ID: " + user.getId() + " | Name: " + user.getName());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
