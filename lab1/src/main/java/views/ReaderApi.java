package views;

import controllers.Facade;
import models.Category;
import models.News;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/read")
@Produces(MediaType.APPLICATION_JSON)
public class ReaderApi {
    private final Facade facade = new Facade();

    @GET
    @Path("/categories")
    public List<Category> getAllCategories() {
        return facade.getCategoryController().getAllCategories();
    }

    @GET
    @Path("/categories/{id}")
    public Category getCategoryById(@PathParam("id") long id) {
        return facade.getCategoryController().getCategoryById(id);
    }

    @GET
    @Path("/news")
    public List<News> getAllNews() {
        return facade.getNewsController().getAllNews();
    }

    @GET
    @Path("/news/{id}")
    public News getNewsById(@PathParam("id") long id) {
        return facade.getNewsController().getNewsById(id);
    }
}
