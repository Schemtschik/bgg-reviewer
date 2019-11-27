package ru.eshemchik.bgg.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.eshemchik.bgg.pojo.Mechanic;

/**
 * @author eshemchik
 */
@Repository
public interface MechanicsDao extends CrudRepository<Mechanic, Integer> {
}
