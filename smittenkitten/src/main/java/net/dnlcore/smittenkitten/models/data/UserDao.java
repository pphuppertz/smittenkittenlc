package net.dnlcore.smittenkitten.models.data;

import net.dnlcore.smittenkitten.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserDao extends CrudRepository<User, Integer> {
}
