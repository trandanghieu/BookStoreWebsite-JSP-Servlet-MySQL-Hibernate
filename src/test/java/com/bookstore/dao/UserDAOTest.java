package com.bookstore.dao;

import com.bookstore.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserDAOTest extends Object {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static UserDAO userDAO;


    @BeforeAll
    public static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
        userDAO = new UserDAO(entityManager);

    }
    @Test
    public void testCreateUsers() {
        Users user = new Users();
        user.setEmail("duytung@gmail.com");
        user.setPassword("duytung");
        user.setFullName("Phan Duy Tung");

        user = userDAO.create(user);

        assertTrue(user.getUserId() > 0);
        //System.out.println("ID: " + user.getUserId());
    }

    @AfterAll
    public static void afterAll() {
        entityManager.close();
        entityManagerFactory.close();
    }
}