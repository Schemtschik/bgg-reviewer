package ru.eshemchik.bgg.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author eshemchik
 */
@Entity
@Table(name = "categories")
public final class Category {
    @Id
    private int id;
    private String name;

    protected Category() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
