package views;

import controllers.Facade;
import models.Category;
import models.News;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/write")
@Produces(MediaType.APPLICATION_JSON)
public class WriterApi {
    private final Facade facade = new Facade();

    @POST
    @Path("/categories")
    public void createCategory(Category category) {
        facade.getCategoryController().createCategory(category);
    }

    @PUT
    @Path("/categories/{id}")
    public void updateCategory(@PathParam("id") long id, Category category) {
        facade.getCategoryController().updateCategory(id, category);
    }

    @POST
    @Path("/news")
    public void createNews(News news) {
        facade.getNewsController().createNews(news);
    }

    @PUT
    @Path("/news/{id}")
    public void updateNews(@PathParam("id") long id, News news) {
        facade.getNewsController().updateNews(id, news);
    }
}
