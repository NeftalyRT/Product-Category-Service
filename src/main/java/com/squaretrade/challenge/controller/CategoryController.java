package com.squaretrade.challenge.controller;

import com.squaretrade.challenge.entity.Category;
import com.squaretrade.challenge.entity.Keyword;
import com.squaretrade.challenge.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable Integer id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("{id}")
    public Category update(@PathVariable Integer id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        categoryService.delete(id);
    }

    @GetMapping("{id}/keywords")
    public List<Keyword> getKeywords(@PathVariable Integer id) {
        return categoryService.getCategoryKeywords(id);
    }

    @GetMapping("{id}/level")
    public Integer getCategoryLevel(@PathVariable Integer id) {
        return categoryService.getCategoryLevel(id);
    }
}
