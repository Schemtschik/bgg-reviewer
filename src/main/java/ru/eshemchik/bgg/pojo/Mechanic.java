package ru.eshemchik.bgg.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author eshemchik
 */
@Entity
@Table(name = "mechanics")
public final class Mechanic {
    @Id
    private int id;
    private String name;

    protected Mechanic() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}