package com.bookstore.dao;

import com.bookstore.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDAOTest extends Object {
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

    @Test
    public void testCreateUserFieldNotSet() {
        Users user = new Users();
        // Gọi create() một lần
        assertThrows(PersistenceException.class, () -> {
            userDAO.create(user);
        });
    }

    @Test
    public void testUpdateUser() {
        Users user = new Users();
        user.setUserId(2);
        user.setEmail("trandanghieu2432002@gmail.com");
        user.setFullName("Tran Dang Hieu");
        user.setPassword("Danghieu2432002");
        user = userDAO.update(user);
        String expected = "Danghieu2432002";
        String actual = user.getPassword();
        assertEquals(expected, actual);
    }


    @Test
    public void testGetUsersFound() {
        Integer userId = 1;
        Users user = userDAO.get(userId);

        assertNotNull(user);
    }
    @Test
    public void testGetUsersNotFound(){
        Integer userId = 99;
        Users user = userDAO.get(userId);
        assertNull(user);
    }
    @Test
    public void testDeleteUser(){
        Integer userId = 5;
        userDAO.delete(userId);

        Users user = userDAO.get(userId);
        assertNull(user);
    }
    @Test
    public void testDeleteNonExitsUsers(){
        Integer userId = 55;
        assertThrows(PersistenceException.class, () -> {
            userDAO.delete(userId);
        });

    }
    @Test
    public void testListAll(){
        List<Users> listUsers = userDAO.listAll();
        for(Users user:listUsers){
            System.out.println(user.getUserId());
        }
        assertTrue(listUsers.size()>0);
    }
    @Test
    public void testCount(){
        long totalUsers = userDAO.count();
        assertEquals(33,totalUsers);
    }


    @AfterAll
    public static void afterAll() {
        entityManager.close();
        entityManagerFactory.close();
    }
}

