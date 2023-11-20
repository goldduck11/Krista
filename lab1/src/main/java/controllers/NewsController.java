package controllers;

import models.News;

import java.util.List;
import java.util.UUID;

public interface NewsController {
    List<News> getAllNews();
    News getNewsById(UUID uuid);
    List<News> getNewsByCategory(long categoryId);
    void createNews(News news);
    void updateNews(long id, News news);
    void deleteNews(long id);
}
