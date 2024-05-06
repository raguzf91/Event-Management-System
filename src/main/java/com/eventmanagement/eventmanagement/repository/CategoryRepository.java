package com.eventmanagement.eventmanagement.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.eventmanagement.eventmanagement.model.Category;

public interface CategoryRepository {
    
    Category findById(int id) throws DataAccessException;

    Category findByName(String name) throws DataAccessException;

    Collection<Category> findAll() throws DataAccessException;

    void save(Category category) throws DataAccessException;
    
    void delete(Category category) throws DataAccessException;
}
