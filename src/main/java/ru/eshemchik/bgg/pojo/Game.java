package ru.eshemchik.bgg.pojo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author eshemchik
 */
@Entity
@Table(name = "games")
public final class Game {
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

    @ManyToMany
    @JoinTable(
            name = "game_to_category",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "game_to_family",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "family_id"))
    private List<Family> families;

    @ManyToMany
    @JoinTable(
            name = "game_to_designers",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "designer_id"))
    private List<Designer> designers;

    @ManyToMany
    @JoinTable(
            name = "game_to_mechanics",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "mechanic_id"))
    private List<Mechanic> mechanics;

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

    public List<Category> getCategories() {
        return categories;
    }

    public List<Family> getFamilies() {
        return families;
    }

    public List<Designer> getDesigners() {
        return designers;
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }
}
