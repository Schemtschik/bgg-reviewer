package ru.eshemchik.bgg.pojo;

import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author eshemchik
 */
@Entity
@Table(name = "games")
public final class Game implements Cloneable {
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
    private List<Category> categoriesInternal;
    @Transient
    private List<Category> categories = Collections.emptyList();

    @ManyToMany
    @JoinTable(
            name = "game_to_family",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "family_id"))
    private List<Family> familiesInternal;
    @Transient
    private List<Family> families = Collections.emptyList();

    @ManyToMany
    @JoinTable(
            name = "game_to_designers",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "designer_id"))
    private List<Designer> designersInternal;
    @Transient
    private List<Designer> designers = Collections.emptyList();

    @ManyToMany
    @JoinTable(
            name = "game_to_mechanics",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "mechanic_id"))
    private List<Mechanic> mechanicsInternal;
    @Transient
    private List<Mechanic> mechanics = Collections.emptyList();

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

    public Game rich() {
        try {
            Game temp = (Game)this.clone();
            temp.categories = categoriesInternal;
            temp.designers = designersInternal;
            temp.mechanics = mechanicsInternal;
            temp.families = familiesInternal;
            return temp;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error cloning game");
        }

    }
}
