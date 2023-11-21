package providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.util.JSON;
import models.News;
import org.bson.Document;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MongoDBProvider implements SQLProvider {

    private final MongoClientURI URI = new MongoClientURI("mongodb://localhost:27017");

    @Override
    public List<News> getAllNews() {
        try (MongoClient mongodb = new MongoClient(this.URI)) {
            DB db = mongodb.getDB("customData-database");
            DBCursor customDataCollection = db.getCollection("customDataList").find();
            List<News> myCustomDataList; // this list will hold your custom data
            ObjectMapper objectMapper = new ObjectMapper();
            myCustomDataList = objectMapper.readValue(JSON.serialize(customDataCollection),
                    new TypeReference<List<News>>() {
                    });
           return myCustomDataList;
        } catch (MongoException | JsonProcessingException me) {
            System.err.println(me);
        }
        return null;
    }

    @Override
    public void update(News news) {
        try (MongoClient mongodb = new MongoClient(this.URI)) {
            MongoDatabase db = mongodb.getDatabase(NameDB.LOCAL);
            MongoCollection collection = db.getCollection("startup_log");
            Gson gson = new Gson();
            String json = gson.toJson(news);
            BasicDBObject query = new BasicDBObject();
            query.put("suitename", json);
            BasicDBObject push = new BasicDBObject();
            collection.updateOne(query, push);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(News news) {
        try (MongoClient mongodb = new MongoClient(this.URI)) {
            MongoDatabase db = mongodb.getDatabase(NameDB.LOCAL);
            MongoCollection collection = db.getCollection("startup_log");
            Gson gson = new Gson();
            String json = gson.toJson(news);
            BasicDBObject basicDBObject = new BasicDBObject("Name", json );
            BasicDBObject document = new BasicDBObject(basicDBObject);
            collection.deleteMany(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(News news) {
        try (MongoClient mongodb = new MongoClient(this.URI)) {
            mongodb.getDatabase(NameDB.LOCAL);
            DB db = mongodb.getDB("customData-database");
            Gson gson = new Gson();
            String json = gson.toJson(news);
            BasicDBObject basicDBObject = new BasicDBObject("Name", json );
            DBCollection dbCollection = db.getCollection("NameColl");
            dbCollection.save(basicDBObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
