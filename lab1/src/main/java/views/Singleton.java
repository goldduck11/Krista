package views;

import views.MessageBodyWriters.CategoryToJsonProvider;
import views.MessageBodyWriters.ListToJsonProvider;
import views.MessageBodyWriters.NewsToJsonProvider;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class Singleton extends Application {
    private Set<Object> singletons = new HashSet<>();

    public Singleton(){
        singletons.add(new ReaderApi());
        singletons.add(new WriterApi());
        singletons.add(new ListToJsonProvider());
        singletons.add(new NewsToJsonProvider());
        singletons.add(new CategoryToJsonProvider());
    }

    @Override
    public Set<Object> getSingletons(){
        return singletons;
    }
}
