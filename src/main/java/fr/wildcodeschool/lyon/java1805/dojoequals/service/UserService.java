package fr.wildcodeschool.lyon.java1805.dojoequals.service;

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
		// TODO done
		for (User user : userDao.getAll()) {
			if (user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}

	public User byName(String name) {
		// TODO done
		for (User user : userDao.getAll()) {
			if (user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}

	public void add(User user) {
		userDao.add(user);
	}
}
