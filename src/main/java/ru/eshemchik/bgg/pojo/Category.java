package ru.eshemchik.bgg.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author eshemchik
 */
@Entity
@Table(name = "categories")
public final class Category implements Cluster {
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

    @Override
    public String getClusterType() {
        return "category";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return id == category.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
