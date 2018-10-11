package fr.wildcodeschool.lyon.java1805.dojoequals.dao;

import static java.util.Collections.unmodifiableSet;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import fr.wildcodeschool.lyon.java1805.dojoequals.model.User;

public @ApplicationScoped class MemoryUserDao implements UserDao {
	private Set<User> users;

	private @PostConstruct void initUsers() {
		// TODO read JSON file using JSON-B
		// getClass().getResourceAsStream("/users.json");
		// See http://json-b.net/getting-started.html
		users = new HashSet<>();
	}

	public @Override Set<User> getAll() {
		return unmodifiableSet(users);
	}

	public @Override void add(User user) {
		users.add(user);
	}
}
