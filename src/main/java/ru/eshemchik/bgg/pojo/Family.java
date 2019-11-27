package ru.eshemchik.bgg.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author eshemchik
 */
@Entity
@Table(name = "families")
public final class Family implements Cluster {
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

    @Override
    public String getClusterType() {
        return "family";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Family family = (Family) o;

        return id == family.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
