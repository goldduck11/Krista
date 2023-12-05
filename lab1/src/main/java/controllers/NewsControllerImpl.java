package controllers;

import lombok.SneakyThrows;
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

    @SneakyThrows
    public List<String> getNameNews() {
        return provider.getNameNews();
    }

    //TODO надо будет переделать, чтобы конкретно по запросу доставались данные
    public News getNewsById(UUID uuid) {
        return null;
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
