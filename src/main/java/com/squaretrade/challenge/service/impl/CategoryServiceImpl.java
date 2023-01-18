package com.squaretrade.challenge.service.impl;

import com.squaretrade.challenge.entity.Category;
import com.squaretrade.challenge.entity.Keyword;
import com.squaretrade.challenge.repository.CategoryRepository;
import com.squaretrade.challenge.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category not found"));
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Integer id, Category category) {
        category.setId(id);
        return repository.save(category);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Keyword> getCategoryKeywords(Integer id) {
        Category category = getById(id);
        List<Keyword> keywords = category.getKeywords();

        if ((keywords == null || keywords.isEmpty()) && category.getParent() != null) {
            return getCategoryKeywords(category.getParent().getId());
        }

        return keywords;
    }

    @Override
    public Integer getCategoryLevel(Integer id) {
        int level = 1;
        Category category = getById(id);
        Category parent = category.getParent();

        while (parent != null) {
            level++;
            parent = parent.getParent();
        }

        return level;
    }


}
