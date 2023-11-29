package providers;

import models.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class PostgreSQLProvider implements SQLProvider {
    private final SessionFactory sessionFactory = null;
//            new Configuration().configure("hibernatePostgre.cfg.xml").buildSessionFactory();

    @Override
    public void add(News news) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(news);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<String> getNameNews() {
        return null;
    }

    @Override
    public News getNews() {
        return null;
    }

    @Override
    public void update(News news) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(news);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(News news) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(news);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
