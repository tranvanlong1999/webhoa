package com.shopmilk.service;

import java.util.List;

import com.shopmilk.entities.Category;

public interface CategoryService {
	
	Iterable<Category> findAll();

    List<Category> search(String q);

    Category findOne(int id);

    void save(Category category);

    void delete(int id);
	
}
