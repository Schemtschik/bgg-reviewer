package ru.eshemchik.bgg.pojo;

import java.util.List;

/**
 * @author eshemchik
 */
public class GamesCluster {
    private final Cluster cluster;
    private final List<Game> games;

    public GamesCluster(Cluster cluster, List<Game> games) {
        this.cluster = cluster;
        this.games = games;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public List<Game> getGames() {
        return games;
    }
}
