package providers;

public class MongoDBFactory extends ProviderFactory {
    @Override
    protected SQLProvider createProvider() {
        return new MongoDBProvider();
    }
}
