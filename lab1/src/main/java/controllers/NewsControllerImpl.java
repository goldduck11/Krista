package controllers;

import providers.Factory;
import models.News;
import providers.SQLProvider;

import java.util.List;
import java.util.UUID;

public class NewsControllerImpl implements NewsController {
    SQLProvider provider;
    public NewsControllerImpl(String type) {
        provider = Factory.create(type);
    }

    public List<News> getAllNews() {
        return provider.getAllNews();
    }

    public News getNewsById(UUID uuid) {
        return provider.getAllNews().stream().filter(news -> news.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    public List<News> getNewsByCategory(long categoryId) {
        return null;
    }

    public void createNews(News news) {
        provider.add(news);
    }

    public void updateNews(long id, News news) {

    }

    public void deleteNews(long id) {

    }
}
