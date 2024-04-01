<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../UserServlet?cmd=logar" method="post">
		Usuario: <br/> <input type="email" name="email"/><br/>
		Senha: <br/> <input type="password" name="password"/><br/>
		<input type="submit" value="logar"/>	
		
		
	
	</form>
</body>
</html>