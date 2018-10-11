package fr.wildcodeschool.lyon.java1805.dojoequals.dao;

import java.util.Set;

import fr.wildcodeschool.lyon.java1805.dojoequals.model.User;

public interface UserDao {
	Set<User> getAll();

	void add(User user);
}
