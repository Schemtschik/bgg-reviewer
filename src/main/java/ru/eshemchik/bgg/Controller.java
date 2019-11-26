package ru.eshemchik.bgg;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.eshemchik.bgg.dao.GamesDao;

/**
 * @author eshemchik
 */
@RestController
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    private final GamesDao gamesDao;

    public Controller(GamesDao gamesDao) {
        this.gamesDao = gamesDao;
    }

    @RequestMapping(value = "/get-game")
    public Response getGame(@RequestParam("id") int id) {
        return get(() -> gamesDao.findById(id).orElseThrow(() -> new RuntimeException("No such game")));
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
