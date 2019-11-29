package ru.eshemchik.bgg.pojo;

import java.util.Collections;
import java.util.List;

/**
 * @author eshemchik
 */
public abstract class WithGames<T extends WithGames> implements Cloneable {
    protected List<Game> games = Collections.emptyList();

    protected abstract List<Game> getGamesInternal();

    public List<Game> getGames() {
        return games;
    }

    public T withGames() {
        try {
            T temp = (T)this.clone();
            temp.games = getGamesInternal();
            return temp;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone WithGames object");
        }
    }
}
