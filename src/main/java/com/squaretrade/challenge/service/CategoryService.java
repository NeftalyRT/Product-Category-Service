package com.squaretrade.challenge.service;

import com.squaretrade.challenge.entity.Category;
import com.squaretrade.challenge.entity.Keyword;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category getById(Integer id);

    Category save(Category category);

    Category update(Integer id, Category category);

    void delete(Integer id);

    List<Keyword> getCategoryKeywords(Integer id);

    Integer getCategoryLevel(Integer id);
}
