package net.dnlcore.smittenkitten.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
    public enum Fertility {
            FERTILE, INFERTILE
        }
    public enum Environment {
        Indoor, Outdoor, Both
    }

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @Size(min = 2, max = 25)
    private String email;
    @NotNull
    private int age;
    @NotNull
    @Size(min = 2, max = 256)
    private String location;
    @NotNull
    @Size(min = 2, max = 50)
    private String name;
    @NotNull
    private Fertility fertility;
    private String likes;
    private String dislikes;
    @NotNull
    private Environment environment;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fertility getFertility() {
        return fertility;
    }

    public void setFertility(Fertility fertility) {
        this.fertility = fertility;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDislikes() {
        return dislikes;
    }

    public void setDislikes() {
        this.dislikes = dislikes;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}

