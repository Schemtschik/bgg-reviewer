package ru.eshemchik.bgg.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.eshemchik.bgg.pojo.Game;

/**
 * @author eshemchik
 */
@Repository
public interface GamesDao extends CrudRepository<Game, Integer> {

}
