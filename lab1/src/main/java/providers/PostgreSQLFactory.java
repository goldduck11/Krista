package providers;

public class PostgreSQLFactory extends ProviderFactory {
    @Override
    protected SQLProvider createProvider() {
        return new PostgreSQLProvider();
    }
}
