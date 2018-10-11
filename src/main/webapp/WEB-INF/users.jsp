<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
</head>
<body>
	<p>There are ${userCount} user${userCount > 1 ? "s" : ""}.</p>
	<form>
		<input name=email placeholder=Email> <input type=submit
			value="Find user">
	</form>
	<form>
		<input name=name placeholder=Name> <input type=submit
			value="Find user">
	</form>
	<c:choose>
		<c:when test="${user}">
			<ul>
				<li>Name: ${user.name}</li>
				<li>Email: ${user.email}</li>
				<li>Gender: ${user.gender}</li>
				<li>Age: ${user.age}</li>
				<li>Eye color: ${user.eyeColor}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No user found.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>