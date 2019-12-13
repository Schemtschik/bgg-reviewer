package ru.eshemchik.bgg.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

/**
 * @author eshemchik
 */
@Entity
@NamedStoredProcedureQuery(
        name = "games_category_rating",
        procedureName = "games_category_rating",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "year"),
        }
)
public final class CategoryWithRating {
    @Id
    private int id;
    private String category;
    private int year;
    private double rating;

    public CategoryWithRating(int id, String category, int year, double rating) {
        this.id = id;
        this.category = category;
        this.year = year;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return category;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }
}
