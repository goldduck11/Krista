package controllers;

public class Facade {
    private final CategoryController categoryController = new CategoryControllerImpl();
    private final NewsController newsController = new NewsControllerImpl();

    public CategoryController getCategoryController() {
        return categoryController;
    }

    public NewsController getNewsController() {
        return newsController;
    }
}
