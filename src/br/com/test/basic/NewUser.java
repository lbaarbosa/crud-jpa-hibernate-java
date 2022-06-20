package br.com.test.basic;

import br.com.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NewUser {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("crud-jpa-hibernate - java");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = new User("Leonardo Leitão", "leonardo@gmail.com");

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        System.out.println("The generated ID was: " + user.getId());

        entityManager.close();
        entityManagerFactory.close();

    }
}
