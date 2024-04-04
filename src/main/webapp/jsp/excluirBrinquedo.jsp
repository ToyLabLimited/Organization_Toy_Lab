<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Brinquedo</title>
</head>
<body>
	<h2>Excluir brinquedo</h2>
	<jsp:useBean id="toy" scope="session"
		class="br.com.toylab.model.Toy" />
	<%
	SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	%>
	<form action="ToyServlet?cmd=excluir" method="post">
		<table border="1">
			<tr>
				<td>Codigo</td>
				<td><input type="text" size="60" name="codigo_brinquedo"
					value="<%=toy.getCode()%>"  /></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit"
					value="Confirmar exclusão" /></th>
			</tr>
			<tr>
				<th colspan="2"><a href="index.html">Página Principal</a></th>
			</tr>
		</table>
	</form>
</body>
</html>