package providers;

import models.News;
import org.json.JSONException;

import java.util.List;

public interface SQLProvider {
    List<String> getNameNews() throws JSONException;
    News getNews();
    void update(News news);
    void delete(News news);
    void add(News news);
}
