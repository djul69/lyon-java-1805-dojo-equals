package fr.wildcodeschool.lyon.java1805.dojoequals.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.wildcodeschool.lyon.java1805.dojoequals.model.User;
import fr.wildcodeschool.lyon.java1805.dojoequals.service.UserService;

public @WebServlet("") class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private @Inject UserService userService;

	protected @Override void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final String name = req.getParameter("name"), email = req.getParameter("email");

		final User user;
		if (name != null) {
			user = userService.byName(name);
		} else if (email != null) {
			user = userService.byEmail(email);
		} else {
			user = null;
		}

		req.setAttribute("user", user);

		forwardToJsp(req, resp);
	}

	protected @Override void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final String name = req.getParameter("name"), email = req.getParameter("email"),
				gender = req.getParameter("gender"), eyeColor = req.getParameter("eyeColor");
		final int age = Integer.parseInt(req.getParameter("age"));

		// TODO use name, email, …
		final User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setGender(gender);
		user.setEyeColor(eyeColor);
		user.setAge(age);

		userService.add(user);

		req.setAttribute("user", user);

		forwardToJsp(req, resp);
	}

	private void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("userCount", userService.count());

		req.getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
	}
}
