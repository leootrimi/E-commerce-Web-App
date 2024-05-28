package com.eCommerce.eCommerceApp.Services;

import com.eCommerce.eCommerceApp.Models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category saveCategory(Category category);
    void deleteCategory(Long id);
}
