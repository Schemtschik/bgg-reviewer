package ru.eshemchik.bgg.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.eshemchik.bgg.pojo.Designer;

/**
 * @author eshemchik
 */
@Repository
public interface DesignersDao extends CrudRepository<Designer, Integer> {
}
