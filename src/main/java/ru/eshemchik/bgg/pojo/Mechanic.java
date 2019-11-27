package ru.eshemchik.bgg.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author eshemchik
 */
@Entity
@Table(name = "mechanics")
public final class Mechanic implements Cluster {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mechanic mechanic = (Mechanic) o;

        return id == mechanic.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String getClusterType() {
        return "mechanic";
    }
}