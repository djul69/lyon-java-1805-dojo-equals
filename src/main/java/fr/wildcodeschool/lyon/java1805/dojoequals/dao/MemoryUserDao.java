package fr.wildcodeschool.lyon.java1805.dojoequals.dao;

import static java.util.Collections.unmodifiableSet;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import fr.wildcodeschool.lyon.java1805.dojoequals.model.User;

public @ApplicationScoped class MemoryUserDao implements UserDao {
	private Set<User> users;

	private @PostConstruct void initUsers() {
		// TODO read JSON file using JSON-B
		// getClass().getResourceAsStream("/users.json");
		// See http://json-b.net/getting-started.html (Mapping a collection)
		Jsonb jsonb = JsonbBuilder.create();
		users = jsonb.fromJson(getClass().getResourceAsStream("/users.json"), new HashSet<User>() {
			private static final long serialVersionUID = 1L;
		}.getClass().getGenericSuperclass());
	}

	public @Override Set<User> getAll() {
		return unmodifiableSet(users);
	}

	public @Override void add(User user) {
		users.add(user);
	}
}
