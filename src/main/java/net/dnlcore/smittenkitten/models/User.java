package net.dnlcore.smittenkitten.models;

import com.amdelamar.jhash.Hash;
import com.amdelamar.jhash.exception.InvalidHashException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User {
    public enum Fertility {
            Fertile, Infertile
        }
    public enum Environment {
        Indoor, Outdoor, Both
    }

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @Email(message="This don't work")
    private String email;
    @NotNull
    @Positive(message = "You need to be older than 0.")
    private int age;
    @NotNull
    @Size(min = 2, message="2 characters or more please")
    @Size(max=256, message="Isn't that a bit long?")
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

    private String storedPassword;
    private boolean doPasswordsMatch;

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
        this.location = location.trim();
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

    public void setPassword(String pwd, String confirmedPwd) throws Exception {
        if (!confirmedPwd.equals(pwd))
        {
            //let's make sure this interrupts the entire process
            doPasswordsMatch = false;
            throw new Exception("Passwords do not match.");
        }
        else {
            doPasswordsMatch = true;
            storedPassword = getHashedPassword(pwd);
        }
    }

    public boolean verifyPassword(String pwdAttempt) {
        try {
            if (Hash.password(pwdAttempt.toCharArray()).verify(storedPassword)) return true;
        }
        catch (InvalidHashException e)
        {
            //this means false
        }
        return false;
    }

    private String getHashedPassword(String pwd) {
        char[] pwdArray = pwd.toCharArray();
        return Hash.password(pwdArray).create();
    }
}

