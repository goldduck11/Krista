package views;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class Singleton extends Application {
    private Set<Object> singletons = new HashSet<>();

    public Singleton(){
        singletons.add(new ReaderApi());
        singletons.add(new WriterApi());
        singletons.add(new ListToJsonProvider());
    }

    @Override
    public Set<Object> getSingletons(){
        return singletons;
    }
}
