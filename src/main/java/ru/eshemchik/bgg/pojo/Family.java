package ru.eshemchik.bgg.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author eshemchik
 */
@Entity
@Table(name = "families")
public final class Family {
    @Id
    private int id;
    private String name;

    protected Family() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
