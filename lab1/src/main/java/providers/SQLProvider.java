package providers;

import models.News;

import java.util.List;

public interface SQLProvider {
    List<News> getAllNews();
    void update(News news);
    void delete(News news);
    void add(News news);
}
