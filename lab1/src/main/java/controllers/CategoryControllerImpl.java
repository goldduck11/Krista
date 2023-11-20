package controllers;

import models.Category;
import providers.Factory;
import providers.SQLProvider;

import java.util.List;

public class CategoryControllerImpl implements CategoryController {
    SQLProvider provider;
    public CategoryControllerImpl(String type) {
        provider = Factory.create(type);
    }

    public List<Category> getAllCategories() {
        return null;
    }

    public Category getCategoryById(long id) {
        return null;
    }

    public void createCategory(Category category) {

    }

    public void updateCategory(long id, Category category) {

    }

    public void deleteCategory(long id) {

    }
}
