package controllers;

import models.News;

import java.util.List;

public interface NewsController {
    List<News> getAllNews();
    News getNewsById(long id);
    List<News> getNewsByCategory(long categoryId);
    void createNews(News news);
    void updateNews(long id, News news);
    void deleteNews(long id);
}
