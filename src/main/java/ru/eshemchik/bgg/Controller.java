package ru.eshemchik.bgg;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.eshemchik.bgg.dao.DataProvider;

/**
 * @author eshemchik
 */
@RestController
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    private final DataProvider dataProvider;

    public Controller(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @RequestMapping(value = "/get-game")
    public Response getGame(@RequestParam("id") int id) {
        return get(() -> dataProvider.getGameById(id));
    }

    @RequestMapping(value = "/get-category")
    public Response getCategory(@RequestParam("id") int id) {
        return get(() -> dataProvider.getCategoryById(id));
    }

    @RequestMapping(value = "/get-designer")
    public Response getDesigner(@RequestParam("id") int id) {
        return get(() -> dataProvider.getDesignerById(id));
    }

    @RequestMapping(value = "/get-family")
    public Response getFamily(@RequestParam("id") int id) {
        return get(() -> dataProvider.getFamilyById(id));
    }

    @RequestMapping(value = "/get-mechanic")
    public Response getMachanic(@RequestParam("id") int id) {
        return get(() -> dataProvider.getMechanicById(id));
    }

    @RequestMapping(value = "/get-categories")
    public Response getCategories() {
        return get(dataProvider::getCategories);
    }

    @RequestMapping(value = "/get-designers")
    public Response getDesigners() {
        return get(dataProvider::getDesigners);
    }

    @RequestMapping(value = "/get-families")
    public Response getFamilies() {
        return get(dataProvider::getFamilies);
    }

    @RequestMapping(value = "/get-mechanics")
    public Response getMechanics() {
        return get(dataProvider::getMechanics);
    }

    private <T> Response get(Supplier<T> supplier) {
        try {
            return Response.ok(supplier.get());
        } catch (Exception e) {
            return Response.error(e);
        }
    }

    private Response run(Runnable runnable) {
        try {
            runnable.run();
            return Response.ok("");
        } catch (Exception e) {
            return Response.error(e);
        }
    }
}
