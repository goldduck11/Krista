package providers;

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import models.Category;
import models.News;
import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.*;

@Stateless
public class MongoDBProvider implements SQLProvider {


    @Override
    public List getNameNews() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("local");
        MongoCollection<Document> collection = database.getCollection("News");
        MongoCursor<Document> cursor = collection.find().iterator();
        List<News> list = new ArrayList<>();
        while (cursor.hasNext()) {
            try {
                Document document = cursor.next();
                JSONObject jsonObject = new JSONObject(document.toJson());
                System.out.println(jsonObject.getJSONObject("_id"));
                list.add(new News(UUID.fromString(jsonObject.getJSONObject("_id").get("UUID").toString()),
                        (List<Category>) jsonObject.getJSONObject("_id").get("category"),
                        (String) jsonObject.getJSONObject("_id").get("title"),
                        (String) jsonObject.getJSONObject("_id").get("text"),
                        (Date) jsonObject.getJSONObject("_id").get("date")));
            }catch (JSONException e) {
                return new ArrayList<String>(Collections.singleton("Возникла ошибка поиска данных...."));
            }
        }
        cursor.close();
        return list.size() == 1 ?
             new ArrayList<String>(Collections.singleton("Данные не были найдены....")) : list ;
    }

    @Override
    public News getNews() {
        return null;
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
        return;
    }

    @Override
    public void add(News news) {
        return;
    }
}
