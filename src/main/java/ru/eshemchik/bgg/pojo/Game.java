package ru.eshemchik.bgg.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author eshemchik
 */
@Entity
@Table(name = "games")
public class Game {
    @Id
    private int id;
    private String name;
    @Column(name = "picture")
    private String pictureUrl;
    private String description;
    @Column(name = "player_min_age")
    private int playerMinAge;
    @Column(name = "players_min_amount")
    private int playersMinAmount;
    @Column(name = "players_max_amount")
    private int playersMaxAmount;
    private int duration;
    @Column(name = "release_year")
    private int releaseYear;
    private double rating;

    protected Game() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getDescription() {
        return description;
    }

    public int getPlayerMinAge() {
        return playerMinAge;
    }

    public int getPlayersMinAmount() {
        return playersMinAmount;
    }

    public int getPlayersMaxAmount() {
        return playersMaxAmount;
    }

    public int getDuration() {
        return duration;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }
}
