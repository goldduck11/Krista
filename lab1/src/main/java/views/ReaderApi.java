package views;

import controllers.Facade;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/read")
@Produces(MediaType.APPLICATION_JSON)
public class ReaderApi {
    private final Facade facade = new Facade("mongo");

    @GET
    @Path("/categories")
    public Response getAllCategories() {
        return Response.status(Response.Status.OK)
                .entity(facade.getCategoryController().getAllCategories())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Path("/categories/{id}")
    public Response getCategoryById(@PathParam("id") long id) {
        return Response.status(Response.Status.OK)
                .entity(facade.getCategoryController().getCategoryById(id))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Path("/news")
    public Response getAllNews() {
        return Response.status(Response.Status.OK)
                .entity(facade.getNewsController().getAllNews())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Path("/news/{id}")
    public Response getNewsById(@PathParam("id") long id) {
        return null;
                /*Response.status(Response.Status.OK)
                .entity(facade.getNewsController().getNewsById(id))
                .type(MediaType.APPLICATION_JSON)
                .build();*/
    }
}
