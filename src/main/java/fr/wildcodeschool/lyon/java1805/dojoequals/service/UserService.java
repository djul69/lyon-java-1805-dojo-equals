package fr.wildcodeschool.lyon.java1805.dojoequals.service;

import java.util.NoSuchElementException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import fr.wildcodeschool.lyon.java1805.dojoequals.dao.UserDao;
import fr.wildcodeschool.lyon.java1805.dojoequals.model.User;

public @ApplicationScoped class UserService {
	private @Inject UserDao userDao;

	public int count() {
		return userDao.getAll().size();
	}

	public User byEmail(String email) {
		// TODO
		throw new NoSuchElementException();
	}

	public User byName(String name) {
		// TODO
		throw new NoSuchElementException();
	}

	public void add(User user) {
		userDao.add(user);
	}
}
