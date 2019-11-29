package ru.eshemchik.bgg.pojo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author eshemchik
 */
@Entity
@Table(name = "mechanics")
public final class Mechanic extends WithGames<Mechanic> {
    @Id
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "game_to_mechanics",
            joinColumns = @JoinColumn(name = "mechanic_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private List<Game> games;

    protected Mechanic() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    @JsonIgnore
    public List<Game> getGamesInternal() {
        return games;
    }
}