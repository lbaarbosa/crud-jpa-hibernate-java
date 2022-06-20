package br.com.test.basic;

import br.com.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateUser {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("crud-jpa-hibernate - java");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, 4L);
        entityManager.detach(user);

        user.setEmail("leonardo@gmail.com");
        user.setName("Leonardo Leitão");
        entityManager.merge(user);

        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}
