package ru.eshemchik.bgg.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import ru.eshemchik.bgg.pojo.Category;
import ru.eshemchik.bgg.pojo.Game;

/**
 * @author eshemchik
 */
@Component
public final class DataProvider {
    private final GamesDao gamesDao;
    private final CategoriesDao categoriesDao;
    private final DesignersDao designersDao;
    private final FamiliesDao familiesDao;
    private final MechanicsDao mechanicsDao;
    private final EntityManager entityManager;

    public DataProvider(
            GamesDao gamesDao,
            CategoriesDao categoriesDao,
            DesignersDao designersDao,
            FamiliesDao familiesDao,
            MechanicsDao mechanicsDao,
            EntityManager entityManager)
    {
        this.gamesDao = gamesDao;
        this.categoriesDao = categoriesDao;
        this.designersDao = designersDao;
        this.familiesDao = familiesDao;
        this.mechanicsDao = mechanicsDao;
        this.entityManager = entityManager;
    }

    public Game getGameById(int id) {
        return gamesDao.findById(id).orElseThrow(() -> new RuntimeException("No such game"));
    }

    public Category getCategoryById(int id) {
        return categoriesDao.findById(id).orElseThrow(() -> new RuntimeException("No such category"));
    }
}
