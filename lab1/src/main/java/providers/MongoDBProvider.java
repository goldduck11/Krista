package providers;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import models.News;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class MongoDBProvider implements SQLProvider {

    @PersistenceContext(unitName = "mangodb")
    private EntityManager entityManager;
    private final static String dbNameNews = "FROM News n";
    private final static String dbDescription = "db.getCollection('News').find({'Description'});";

    @Override
    public List getNameNews() {
        List<News> nameNews = entityManager.createQuery(dbNameNews).getResultList();
        return nameNews;
    }

    @Override
    public News getNews() {
        News descriptionNews = (News) entityManager.createNativeQuery( dbDescription, News.class )
                .getResultList();
        return descriptionNews;
    }

    @Override
    public void update(News news) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(NameDB.LOCAL);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.refresh(News.class);
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void delete(News news) {
        entityManager.remove(news);
    }

    @Override
    public void add(News news) {
        entityManager.getTransaction().begin();
        entityManager.persist(news);
        entityManager.getTransaction().commit();
    }
}
