package providers;

public interface SQLProvider {
    public void update();
    public void delete();
    public void add();
    public SQLProvider build();
}
