package ru.eshemchik.bgg.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author eshemchik
 */
@Entity
@Table(name = "designers")
public final class Designer {
    @Id
    private int id;
    private String name;

    protected Designer() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
