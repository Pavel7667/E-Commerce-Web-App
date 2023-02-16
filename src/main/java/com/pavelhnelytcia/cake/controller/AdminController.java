package com.pavelhnelytcia.cake.controller;

import com.pavelhnelytcia.cake.model.Category;
import com.pavelhnelytcia.cake.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * AdminController class for navigation in the administrative part of the site, which include
 * <p>Main adminHome page.
 * <p>Page for adding categories.
 * <p>Page for adding product.
 */
@Controller
public class AdminController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    //  Category Section

    @GetMapping("/admin/categories")
    public String getCategory(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCategoryAdd(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCategoryAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        } else {
            return "404";
        }
    }


}
