<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form method="post" action="LoginServlet">
		<input type="text" name="login" required />
		<input type="password" name="senha" required />
		
		<input type="submit" value="Entrar" />
	</form>
</body>
</html>