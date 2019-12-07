package ru.eshemchik.bgg.dao;

import java.util.List;
import javax.persistence.EntityManager;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import ru.eshemchik.bgg.pojo.Category;
import ru.eshemchik.bgg.pojo.Designer;
import ru.eshemchik.bgg.pojo.Family;
import ru.eshemchik.bgg.pojo.Game;
import ru.eshemchik.bgg.pojo.Mechanic;

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
        return gamesDao.findById(id).orElseThrow(() -> new RuntimeException("No such game")).rich();
    }

    public Category getCategoryById(int id) {
        return categoriesDao.findById(id).orElseThrow(() -> new RuntimeException("No such category")).withGames();
    }

    public Designer getDesignerById(int id) {
        return designersDao.findById(id).orElseThrow(() -> new RuntimeException("No such category")).withGames();
    }

    public Family getFamilyById(int id) {
        return familiesDao.findById(id).orElseThrow(() -> new RuntimeException("No such category")).withGames();
    }

    public Mechanic getMechanicById(int id) {
        return mechanicsDao.findById(id).orElseThrow(() -> new RuntimeException("No such category")).withGames();
    }

    public List<Category> getCategories() {
        return Lists.newArrayList(categoriesDao.findAll());
    }

    public List<Designer> getDesigners() {
        return Lists.newArrayList(designersDao.findAll());
    }

    public List<Family> getFamilies() {
        return Lists.newArrayList(familiesDao.findAll());
    }

    public List<Mechanic> getMechanics() {
        return Lists.newArrayList(mechanicsDao.findAll());
    }
}
