package controllers;

import models.Category;

import java.util.List;

public interface CategoryController {
    List<Category> getAllCategories();
    Category getCategoryById(long id);
    void createCategory(Category category);
    void updateCategory(long id, Category category);
    void deleteCategory(long id);
}
