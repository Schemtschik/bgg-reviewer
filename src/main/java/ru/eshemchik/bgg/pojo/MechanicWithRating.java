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
        name = "games_mechanics_rating",
        procedureName = "games_mechanics_rating",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "year"),
        }
)
public final class MechanicWithRating {
    @Id
    private int id;
    private String mechanic;
    private int year;
    private double rating;

    public int getId() {
        return id;
    }

    public String getName() {
        return mechanic;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }
}
