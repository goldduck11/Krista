package providers;

public abstract class ProviderFactory {
    public SQLProvider create(){
        SQLProvider provider = createProvider();
        provider.build();
        return provider;
    }
    protected abstract SQLProvider createProvider();
}
