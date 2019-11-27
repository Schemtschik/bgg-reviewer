package ru.eshemchik.bgg.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.eshemchik.bgg.pojo.Family;

/**
 * @author eshemchik
 */
@Repository
public interface FamiliesDao extends CrudRepository<Family, Integer> {
}
