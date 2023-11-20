package views;

import controllers.Facade;
import models.Category;
import models.News;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/write")
public class WriterApi {
    private final Facade facade = new Facade("postgre");

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

    @GET
    @Path("/news/add")
    public Response createNews(    @QueryParam("title") String title,
                                   @QueryParam("text") String text
    ) {
        News news = new News(UUID.randomUUID(), null, title, text, null);
        facade.getNewsController().createNews(news);
        return Response.ok("News added successfully").entity(news).build();
    }

    @PUT
    @Path("/news/{id}")
    public void updateNews(@PathParam("id") long id, News news) {
        facade.getNewsController().updateNews(id, news);
    }
}
