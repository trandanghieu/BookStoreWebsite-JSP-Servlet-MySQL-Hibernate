package com.bookstore.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UsersTest {

    public static void main(String[] args) {
        Users user = new Users();
        user.setEmail("phucsang@gmail.com");
        user.setPassword("phucsang");
        user.setFullName("Le Truong Phuc Sang");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        System.out.println("A User is persisted.");
    }

}
