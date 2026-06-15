package com.code;
import jakarta.persistence.*;
import java.util.*;

public class HibernateJpaCrud {

    public static void main(String[] args) {

        //HibernateJpaCrud.createRecord();
        HibernateJpaCrud.retrieveRecord();
        // HibernateJpaCrud.updateRecord();

    }

    public static void retrieveRecord() {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
        EntityManager entityManager=emf.createEntityManager();

        entityManager.getTransaction().begin();
        Player p =new Player();
        p.setPlayerName("M.S. Dhoni ");
        p.setScore(1000L);
        entityManager.persist(p);
        p.setPlayerName("Virat Kohli");
        p.setScore(550L);

        entityManager.persist(p);

        entityManager.getTransaction().commit();
        System.out.println("***** From  Player Table *****");
        System.out.println(p.getPlayerName());
        System.out.println(p.getScore());

        //  entitymanager.remove(p); // to delete a record from table.

        List <Player> players=entityManager.createQuery("select a from Player a", Player.class).getResultList();
        players.forEach(s ->{
            System.out.print(s+", ");
        });

    }

    public static void createRecord() {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa-hibernate-mysql");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Player p =new Player();
        //p.setPlayerName("M.S. Dhoni ");
        //p.setScore(1000L);

        p.setPlayerName("Virat Kohli");
        p.setScore(550L);

        entityManager.persist(p);

        entityManager.getTransaction().commit();


    }


//    public static void updateRecord() {
//        EntityManagerFactory emf= Persistence.getEntityManagerFactory("jpa-hibernate-MySQL");
//        EntityManager entityManager =emf.createEntityManager();
//        entityManager.getTransaction().begin();
//        Long key=Long.valueOf(1);
//
//        Player p=entityManager.find(Player.class, key);
//        p.setScore(9999L);
//
//        // ???  // to update the record
//        entityManager.persist(p);
//
//        entityManager.getTransaction().commit();
//    }



}