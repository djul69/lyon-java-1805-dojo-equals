<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
</head>
<body>
	<p>User count: ${userCount}</p>
	<form>
		<input name=email type=email placeholder=Email> <input
			type=submit value="Find user by email">
	</form>
	<form>
		<input name=name placeholder=Name> <input type=submit
			value="Find user by name">
	</form>
	<c:choose>
		<c:when test="${!empty user}">
			<ul>
				<li>Name: ${user.name}</li>
				<li>Email: ${user.email}</li>
				<li>Gender: ${user.gender}</li>
				<li>Age: ${user.age}</li>
				<li>Eye color: ${user.eyeColor}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No user to display.</p>
		</c:otherwise>
	</c:choose>
	<form method=post action=.>
		<fieldset>
			<legend>New user</legend>
			<p>
				<label>Name: <input name=name value="Vanessa Bright"></label><br>
				<label>Email: <input name=email type=email
					value="vanessa.bright@example.com">
				</label><br> <label>Gender: <select name=gender><option
							selected>female</option>
						<option>male</option></select></label><br> <label>Age: <input name=age
					type=number value=30></label><br> <label>Eye color: <input
					name=eyeColor value=blue>
				</label><br>
			</p>
			<p>
				<input type=submit value=Create>
			</p>
		</fieldset>
	</form>
</body>
</html>
