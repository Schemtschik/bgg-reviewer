package ru.eshemchik.bgg.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author eshemchik
 */
@Entity
@Table(name = "designers")
public final class Designer implements Cluster {
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

    @Override
    public String getClusterType() {
        return "designer";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Designer designer = (Designer) o;

        return id == designer.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
