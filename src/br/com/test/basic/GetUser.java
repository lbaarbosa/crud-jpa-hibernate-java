package br.com.test.basic;

import br.com.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetUser {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("crud-jpa-hibernate - java");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = entityManager.find(User.class, 1L);
        System.out.println(user.getName());



        entityManager.close();
        entityManagerFactory.close();

    }
}
