package providers;

import models.News;

import java.util.List;

public interface SQLProvider {
    List<String> getNameNews();
    News getNews();
    void update(News news);
    void delete(News news);
    void add(News news);
}
