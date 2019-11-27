package ru.eshemchik.bgg.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.eshemchik.bgg.pojo.Category;

/**
 * @author eshemchik
 */
@Repository
public interface CategoriesDao extends CrudRepository<Category, Integer> {
}
