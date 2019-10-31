package net.dnlcore.smittenkitten.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Favorites {

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    private List<Favorites> favorites;

    public void addName(Favorites name) {
        favorites.add(name);
    }

    public Favorites(String name) {
        this.name = name;
    }

    public Favorites() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public List<Favorites> getFavorites() {
        return favorites;
    }

}



