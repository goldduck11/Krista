package providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.util.JSON;
import models.News;
import org.bson.Document;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.ogm.jpa.HibernateOgmPersistence;
import org.hibernate.query.Query;
import org.hibernate.sql.Update;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.where;

public class MongoDBProvider implements SQLProvider {

    private final MongoClientURI URI = new MongoClientURI("mongodb://localhost:27017");

    @Override
    public List<News> getAllNews() {
        try (Session session = HibernateMo){

        }
    }

    @Override
    public void update(News news) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mangodb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void delete(News news) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mangodb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.remove(news);
        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public void add(News news) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mangodb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(news);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
