package ru.eshemchik.bgg.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;

import com.google.common.collect.Streams;
import org.springframework.stereotype.Component;

import ru.eshemchik.bgg.pojo.Category;
import ru.eshemchik.bgg.pojo.Game;
import ru.eshemchik.bgg.pojo.GamesCluster;

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

    public GamesCluster getCategoryById(int id) {
        Category category = categoriesDao.findById(id).orElseThrow(() -> new RuntimeException("No such catogory"));
        List<Game> games = Streams.stream(gamesDao.findAll())
                .filter(game -> game.getCategories().contains(category))
                .collect(Collectors.toList());
        return new GamesCluster(
                category,
                games
        );
    }
}
