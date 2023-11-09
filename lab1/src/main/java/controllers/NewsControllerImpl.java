package controllers;

import models.Category;
import models.News;

import java.util.List;
import java.util.UUID;

public class NewsControllerImpl implements NewsController {
    public NewsControllerImpl() {
    }

    public List<News> getAllNews() {
        return List.of(new News(UUID.randomUUID(), new Category(UUID.randomUUID(), "Java"), "title",
                "text", null, null),
                new News(UUID.randomUUID(), new Category(UUID.randomUUID(), "Java"), "title",
                        "text", null, null));
    }

    public News getNewsById(long id) {
        return null;
    }

    public List<News> getNewsByCategory(long categoryId) {
        return null;
    }

    public void createNews(News news) {

    }

    public void updateNews(long id, News news) {

    }

    public void deleteNews(long id) {

    }
}
