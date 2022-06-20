package br.com.test.basic;

import br.com.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteUser {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("crud-jpa-hibernate - java");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = entityManager.find(User.class, 4L);
        System.out.println(user.getId() + " : " + user.getName());

        if(user != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
