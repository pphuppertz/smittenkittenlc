package net.dnlcore.smittenkitten.models.data;

import net.dnlcore.smittenkitten.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserDao extends CrudRepository<User, Integer> {
    List<User> findByName(String name);
}
